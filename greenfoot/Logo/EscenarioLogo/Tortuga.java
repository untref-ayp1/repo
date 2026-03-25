import greenfoot.*;
import java.util.function.Consumer;

public abstract class Tortuga extends Actor {
    protected boolean dibujar = true;
    protected int grosor = 5;
    
    private Cartel cartel;
    
    private static Color[] colores = {
        new Color(189, 147, 249), // Dracula Purple
        new Color(241, 250, 140), // Dracula Yellow
        new Color(255, 184, 108), // Dracula Orange
        new Color(255, 85, 85),   // Dracula Red
        new Color(255, 121, 198), // Dracula Pink
        new Color(80, 250, 123),  // Dracula Green
        new Color(139, 233, 253)  // Dracula Cyan
    };
    private int colorActual = 0;
    
    protected void addedToWorld(World world) {
        this.cartel = ((Mundo)getWorld()).getObjects(Cartel.class).get(0);
        cambiarColor();
    }
    
    private void registrarAccion(String mensaje) {
        cartel.contarPaso();
        ((Mundo)getWorld()).log(mensaje);
    }
    
    public void adelante(int pasos) {
        mover(pasos);
        registrarAccion("adelante(" + pasos + ")");
    }
    
    public void atras(int pasos) {
        mover(-pasos);
        registrarAccion("atras(" + pasos + ")");
    }
    
    private void mover(int pasos) {
        int x0 = getX(), y0 = getY();
        move(pasos);
        linea(x0, y0, getX(), getY());
        this.cartel.contarDistancia(Math.abs(pasos));
        Greenfoot.delay(1);
    }
    
    private void linea(int x0, int y0, int x1, int y1) {
        if (!dibujar) return;
        
        int medio = grosor/2;
        for (int i = -medio; i <= medio; i++) {
            for (int j = -medio; j <= medio; j++) {
                if (Math.abs(i) + Math.abs(j) <= medio) {
                    getWorld().getBackground().drawLine(x0 + i, y0 + j, x1 + i, y1 + j);
                }
            }
        }
    }
    
    public void derecha(int grados) {
        this.turn(grados);
        registrarAccion("derecha(" + grados + ")");
    }
    
    public void izquierda(int grados) {
        this.turn(-grados);
        registrarAccion("izquierdo(" + grados + ")");
    }
    
    public void morir() {
        if (this.getWorld() != null) {
            getWorld().removeObject(this);
        }
    }
    
    // Métodos del trazo
    public void subirLapiz() {
        this.dibujar = false;
        registrarAccion("subirLapiz()");
    }
    
    public void bajarLapiz() {
        this.dibujar = true;
        registrarAccion("subirLapiz()");
    }
    
    public void cambiarColor() {
        cambiarColor(colorActual);
        colorActual++;
    }
    
    public void cambiarColor(int numero) {
        this.colorActual = Math.abs(numero)%colores.length;
        getWorld().getBackground().setColor(colores[colorActual]);
    }
    
    // Utilidades
    protected void repetir(int veces, Consumer<Integer> accion) {
        for (int i = 1; i <= veces; i++) {
            accion.accept(i);
        }
    }
}
