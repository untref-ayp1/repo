import greenfoot.*;

public class TortugaVerde extends Tortuga {
    public void adelante() {
        this.adelante(pasos());
    }
    
    public void atras() {
        this.atras(pasos());
    }
    
    // Este método hace que los pasos en diagonal sean un poco más largos,
    // para coincidir con la cuadrícula.
    private int pasos() {
        if (this.getRotation() % 90 == 0)
            return 50;
        else
            return (int) (50 * Math.sqrt(2));
    }
    
    public void derecha() {
        derecha(45);
    }
    
    public void izquierda() {
        izquierda(45);
    }
}
