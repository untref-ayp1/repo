import greenfoot.*;

public class Cartel extends Actor {
    private int pasos, distancia;

    public Cartel() {
        updateImage();
    }

    public void reset() {
        this.pasos = 0;
        this.distancia = 0;
        updateImage();
    }
    
    public void contarPaso() {
        this.pasos++;
        updateImage();
    }
    
    public void contarDistancia(int distancia) {
        this.distancia += distancia;
        updateImage();
    }

    private void updateImage() {
        String text = this.pasos + " acciones\n" + this.distancia + " pasos";
        
        Font monoFont = new Font("Monospaced", 12);
        GreenfootImage image = new GreenfootImage(110, 40);
        image.setFont(monoFont);
        image.setColor(Color.WHITE);
        image.fill();
        image.setColor(Color.BLACK);
        image.drawString(text, 5, 17);
        setImage(image);
    }
}
