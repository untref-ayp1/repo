import greenfoot.*;

public class PincelSSP2024 extends PincelBase{
    
    public void pintar() {
        int tam = obtenerTamañoDelLienzo();
        int mitad = tam / 2;
        
        // línea vertical (parte A)
        for (int i = 0; i < mitad; i++) {
            pintar(i, mitad);
        }
        
        // centro
        pintar(mitad, mitad);
        
        // diagonales
        for (int i = 1; i <= mitad; i++) {
            pintar(mitad + i, mitad + i);
            pintar(mitad + i, mitad - i);
        }
    }
}
