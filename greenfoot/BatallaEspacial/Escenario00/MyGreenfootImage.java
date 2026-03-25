import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Es un sprite mutable, que puedo configurar
 */
public class MyGreenfootImage extends GreenfootImage {
    private static final Color HIGHLIGHT_COLOR = new Color(30, 200, 200);
    private static final Color SILHOUETTE_COLOR = new Color(30, 30, 30);
    private static final Color SHADOW_COLOR = new Color(30, 30, 30, 100);

    public static final Color[] AURAS = {
            Color.MAGENTA,
            Color.CYAN,
            Color.YELLOW,
            Color.GREEN,
            Color.LIGHT_GRAY
    };

    public MyGreenfootImage(GreenfootImage image) throws IllegalArgumentException {
        super(image);
        configurar();
    }

    public MyGreenfootImage(int width, int height) {
        super(width, height);
        configurar();
    }

    public MyGreenfootImage clone() {
        return new MyGreenfootImage(this);
    }

    /**
     * Este método permite extender el comportamiento para que la imagen
     * se configure sola. Una buena herencia haría uso de él.
     */
    public void configurar() {
    }

    public void shadow() {
        MyGreenfootImage copy = clone();

        clear();
        scale(getWidth(), (int) (getHeight() * 9.0 / 8.0));

        setColor(SHADOW_COLOR);
        fillOval((int) (getWidth() * 0.1), (int) (3.5 * copy.getHeight() / 4), (int) (getWidth() * 0.8),
                getHeight() / 5);

        drawImage(copy, 0, 0);
    }

    public void silhouette() {
        Color shade = SILHOUETTE_COLOR;
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                Color color = getColorAt(x, y);
                setColorAt(x, y, new Color(shade.getRed(), shade.getGreen(), shade.getBlue(), color.getAlpha()));
            }
        }
    }

    public void highlight() {
        highlight(HIGHLIGHT_COLOR);
    }

    public void highlight(Color highlight) {
        MyGreenfootImage copy = clone();

        final int DELTA = 3;

        for (int i = 0; i < DELTA; i++) {
            MyGreenfootImage x = this.clone();
            drawImage(x, 0, -1);
            drawImage(x, 1, 0);
            drawImage(x, -1, 0);
            drawImage(x, 0, 1);
        }

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                Color colorHere = getColorAt(x, y);
                setColorAt(x, y,
                        new Color(highlight.getRed(), highlight.getGreen(), highlight.getBlue(), colorHere.getAlpha()));
            }
        }

        // Y se vuelve a pintar la imagen original encima
        drawImage(copy, 0, 0);
    }

    public void grayscale() {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                Color colorHere = getColorAt(x, y);
                int brightness = (colorHere.getRed() + colorHere.getGreen() + colorHere.getBlue()) / 3;
                setColorAt(x, y, new Color(brightness, brightness, brightness, colorHere.getAlpha()));
            }
        }
    }

    public void flipHorizontally() {
        mirrorHorizontally();
    }

    public void scaleTo(int width, int height) {
        scale(width, height);
    }

    public void scaleToRatio(double ratio) {
        scale((int) (getWidth() * ratio), (int) (getHeight() * ratio));
    }

    public void applyHue(Color color) {
        float colorHue = java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[0];
        applyHue(colorHue);
    }

    private void applyHue(float hueEquipo) {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                Color color = getColorAt(x, y);

                float[] hsb = java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
                java.awt.Color colorEquipoHue = new java.awt.Color(java.awt.Color.HSBtoRGB(hueEquipo, hsb[1], hsb[2]));

                setColorAt(x, y, new Color(colorEquipoHue.getRed(), colorEquipoHue.getGreen(), colorEquipoHue.getBlue(),
                        color.getAlpha()));
            }
        }
    }
}