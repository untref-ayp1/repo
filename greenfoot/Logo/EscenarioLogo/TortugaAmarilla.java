import greenfoot.*;
import java.util.*;
import java.util.function.Consumer;

public class TortugaAmarilla extends Tortuga {
    private List<Instruccion> recuerdo = new LinkedList<Instruccion>();
    private boolean recordando = false;
    
    private Map<String, Consumer<Integer>> accionesConParametro = new HashMap<>();
    private Map<String, Runnable> accionesSinParametro = new HashMap<>();

    public TortugaAmarilla() {
        accionesConParametro.put("adelante", this::adelante);
        accionesConParametro.put("atras", this::atras);
        accionesConParametro.put("izquierda", this::izquierda);
        accionesConParametro.put("derecha", this::derecha);

        accionesSinParametro.put("subirLapiz", this::subirLapiz);
        accionesSinParametro.put("bajarLapiz", this::bajarLapiz);
    }
    
    public void comenzarRecuerdo() {
        borrarRecuerdo();
        this.recordando = true;
    }
    
    public void finalizarRecuerdo() {
        this.recordando = false;
    }
    
    public void borrarRecuerdo() {
        finalizarRecuerdo();
        this.recuerdo.clear();
    }
    
    public void ejecutarRecuerdo() {
        finalizarRecuerdo();
        
        for (Instruccion inst : recuerdo) {
            if (accionesConParametro.containsKey(inst.mensaje)) {
                accionesConParametro.get(inst.mensaje).accept(inst.param);
            } else if (accionesSinParametro.containsKey(inst.mensaje)) {
                accionesSinParametro.get(inst.mensaje).run();
            }
        }
    }
    
    @Override
    public void adelante(int pasos) {
        super.adelante(pasos);
        if (recordando) {
            this.recuerdo.add(new Instruccion("adelante", pasos));
        }
    }
    
    @Override
    public void atras(int pasos) {
        super.atras(pasos);
        // atrás se recuerda automáticamente por su opuesta
    }
    
    @Override
    public void derecha(int grados) {
        super.derecha(grados);
        if (recordando) {
            this.recuerdo.add(new Instruccion("derecha", grados));
        }
    }
    
    @Override
    public void izquierda(int grados) {
        super.izquierda(grados);
        if (recordando) {
            this.recuerdo.add(new Instruccion("izquierda", grados));
        }
    }
    
    @Override
    public void subirLapiz() {
        super.subirLapiz();
        if (recordando) {
            this.recuerdo.add(new Instruccion("subirLapiz", 0));
        }
    }
    
    @Override
    public void bajarLapiz() {
        super.bajarLapiz();
        if (recordando) {
            this.recuerdo.add(new Instruccion("bajarLapiz", 0));
        }
    }
    
    class Instruccion {
        String mensaje;
        int param;
        
        public Instruccion(String mensaje, int param) {
            this.mensaje = mensaje;
            this.param = param;
        }
    }
}
