import greenfoot.*;

public class PincelEjercicio01 extends PincelBase{
    
    public void pintar2() {
        int tam = obtenerTamañoDelLienzo();
        int mitad = tam / 2;
        int pasos = 2 * tam - 2;
        
        for (int i = 0; i <= pasos; i++) {
            System.out.println(i);
            if (i == 0) {
                System.out.println("uno");
                pintar(tam - 1, 0);
            } else if (i <= mitad) {
                System.out.println("dos");
                pintar(tam - 1, i);
                pintar(tam - 1 - i, 0);
            } else if (i < tam - 1) {
                System.out.println("tres");
                pintar(tam - 1 - (i - mitad), mitad);
                pintar(mitad, i - mitad);
            } else if (i == tam) {
                System.out.println("cuatro");
                pintar(mitad, mitad);
            } else if (i > tam && i < tam + mitad) {
                System.out.println("cinco");
                pintar(mitad - (i - tam), mitad);
                pintar(mitad, mitad + (i - tam));
            } else if (i == tam + mitad) {
                System.out.println("seis");
                pintar(0, mitad);
                pintar(mitad, tam - 1);
            } else if (i > tam + mitad) {
                System.out.println("siete");
                pintar(0, mitad - (i - tam - mitad));
                pintar(mitad + (i - tam - mitad), tam - 1);
            }
        }
    }
    
    public void pintar() {
        int tam = obtenerTamañoDelLienzo();
        
        int mitad = tam/2;
        
        pintarCuadrado(mitad, mitad, 0);
        
        pintarTechito(mitad, 0, mitad);
        pintarTechito(mitad, mitad, tam - 1);
    }
    
    private void pintarCuadrado(int tam, int x, int y) {
        for(int i = 0; i <= tam; i++) {
            pintar(x, y + i);
            pintar(x + tam, y+i);
        }
        for(int i = 0; i < tam - 1; i++) {
            pintar(x + 1 + i, y);
            pintar(x + 1 + i, y+tam);
        }
    }
    
    private void pintarTechito(int tam, int x, int y){
        for(int i = 0; i < tam; i++) {
            pintar(x, y-i);
            if (i != 0)
                pintar(x+i, y);
        }
    }
}
