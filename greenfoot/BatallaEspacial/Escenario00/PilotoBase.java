import greenfoot.*;

/**
 * Define el comportamiento base para todos los Pilotos de la Batalla Espacial
 */
public abstract class PilotoBase extends ActorBase {
    protected double ESCALA_X = 0.8;
    protected double ESCALA_Y = 0.8;

    protected int aura;

    protected static int ultima = 0;

    public PilotoBase() {
        this.aura = ultima++;
    }

    public Color getAura() {
        return MyGreenfootImage.AURAS[this.aura % MyGreenfootImage.AURAS.length];
    }

    /**
     * La nave que pilotará
     */
    protected NaveDeAtaque navePilotada;
    GreenfootImage imagenOriginal = new GreenfootImage(getImage());

    /**
     * post: El Piloto se sube a la Nave
     * 
     * @param nave es la Nave a la que se subirá el piloto
     */
    public void subirse(NaveDeAtaque nave) {
        if (navePilotada != null) {
            bajarse();
        }
        navePilotada = nave;
        navePilotada.recibirPiloto(this);
        actualizarImagen();
    }

    /**
     * post: El Piloto deja la Nave
     */
    public void bajarse() {
        navePilotada.bajarPiloto();
        navePilotada = null;
        actualizarImagen();
    }

    /**
     * Actualiza la imagen del Piloto, de acuerdo a su estado
     */
    @Override
    protected void actualizarImagen() {
        int tamCelda = getWorld().getCellSize();

        MyGreenfootImage nuevaImagen;
        if (navePilotada != null) {
            nuevaImagen = new MyGreenfootImage(getImage()) {
                public void configurar() {
                    setTransparency(150);
                }
            };
        } else {
            nuevaImagen = new MyGreenfootImage(imagenOriginal) {
                public void configurar() {
                    highlight(getAura());
                }
            };
        }
        nuevaImagen.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(nuevaImagen);
    }
}
