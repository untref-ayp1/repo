import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;

public class Estela {
    
    private static final double INICIO = 0;
    private static final double UN_TERCIO = 1d / 3;
    private static final double DOS_TERCIOS = 2d / 3;
    private static final double COMPLETO = 1.0;
    
    public static GreenfootImage obtenerFragmentoEstela(LinkedList<Direccion> movimientos, Color colorEstela, World world) {
        int tamCelda = world.getCellSize();
        
        Direccion direccionActual = movimientos.get(movimientos.size() - 1);
        
        Direccion direccionPrevia = movimientos.size() < 2 ? movimientos.get(0) : movimientos.get(movimientos.size() - 2);

        GreenfootImage fragmentoEstela = new GreenfootImage(tamCelda, tamCelda);
        
        int grosorEstela = (tamCelda / 20) + (tamCelda / 20 % 2);

        int transparenciaEstela = 20;
        colorEstela = new Color(colorEstela.getRed(), colorEstela.getGreen(), colorEstela.getBlue(), transparenciaEstela);
        fragmentoEstela.setColor(colorEstela);

        if (direccionPrevia == direccionActual) {
            dibujarEstelaRecta(fragmentoEstela, grosorEstela, tamCelda);
            fragmentoEstela.rotate(direccionActual.rotacion);
        } else if (direccionPrevia == direccionActual.opuesta()) {
            dibujarVueltaEnU(fragmentoEstela, grosorEstela, tamCelda);
            fragmentoEstela.rotate(direccionActual.rotacion);
        } else {
            dibujarCurva(fragmentoEstela, direccionPrevia, direccionActual, grosorEstela, tamCelda);
            fragmentoEstela.rotate(direccionPrevia.rotacion);
        }
        return fragmentoEstela;
    }

    private static int calcularPosicion(double fraccion, int tamCelda) {
        return (int) (tamCelda * fraccion);
    }
    
    private static void dibujarEstelaRecta(GreenfootImage img, int grosor, int tamCelda) {
        int posY = calcularPosicion(DOS_TERCIOS, tamCelda);
        linea(0, posY, tamCelda, posY, grosor, img);
    }

    private static void dibujarVueltaEnU(GreenfootImage img, int grosor, int tamCelda) {
        int posYIda = calcularPosicion(DOS_TERCIOS, tamCelda);
        int posYVuelta = calcularPosicion(UN_TERCIO, tamCelda);

        linea(tamCelda, posYIda, tamCelda / 2, posYIda, grosor, img);
        linea(tamCelda/2, posYVuelta, tamCelda/2, posYIda, grosor, img);
        linea(tamCelda, posYVuelta, tamCelda / 2, posYVuelta, grosor, img);
    }

    private static void dibujarCurva(GreenfootImage img, Direccion dirPrev, Direccion dirActual, int grosor, int tamCelda) {
        boolean esDerecha = dirPrev.derecha() == dirActual;
        
        int posYIda = calcularPosicion(DOS_TERCIOS, tamCelda);
        int posXFinal = calcularPosicion(esDerecha ? UN_TERCIO: DOS_TERCIOS, tamCelda);
        int posYFinal = calcularPosicion(esDerecha ? COMPLETO: INICIO, tamCelda);
        
        linea(0, posYIda, posXFinal, posYIda, grosor, img);
        linea(posXFinal, posYIda, posXFinal, posYFinal, grosor, img);
    }
    
    private static void linea(int x0, int y0, int x1, int y1, int grosor, GreenfootImage img) {
        int medio = grosor/2;
        for (int i = -medio; i <= medio; i++) {
            for (int j = -medio; j <= medio; j++) {
                img.drawLine(x0 + i, y0 + j, x1 + i, y1 + j);
            }
        }
    }
}
