public class PincelEjercicio00 extends PincelBase {
    public void pintar() {
        int tamaño = obtenerTamañoDelLienzo();
        // este pincel traza una diagonal
        for(int i = 0; i < tamaño; i++)
            pintar(2,0);
    }
}
