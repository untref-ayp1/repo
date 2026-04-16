import greenfoot.*;
import java.util.LinkedList;

public class NaveDeAtaque extends NaveAliada implements Atacante {

    /**
     * Representa el estado de los motores de la {@link NaveDeAtaque}.
     */
    protected boolean motoresEncendidos = false;
    protected PilotoBase piloto;
    
    protected LinkedList<Direccion> movimientos = new LinkedList<Direccion>();

    /**
     * Inicializa una nueva NaveDeAtaque con los motores apagados
     */
    public NaveDeAtaque() {
        super();
    }

    /**
     * Inicializa una nueva NaveDeAtaque con los motores apagados. Este constructor
     * es empleado mayormente para la creación de escenarios.
     * 
     * @param direccion es la orientación con la que se creará la NaveDeAtaque
     * @param carga     es la carga de combustible inicial de la NaveDeAtaque
     */
    public NaveDeAtaque(Direccion direccion, int carga) {
        super();
        setDireccion(direccion);
        this.combustible = carga;
    }

    /**
     * pre: posee combustible {@link NaveAliada#combustible} y los motores se
     * encuentran apagados {@link NaveDeAtaque#motoresEncendidos} <br/>
     * post: encenderá sus motores
     */
    public void encenderMotores() {
        if (this.combustible > 0 && !this.motoresEncendidos) {
            this.motoresEncendidos = true;
            Greenfoot.playSound("engine-on.wav");
            int tamCelda = getWorld().getCellSize();
            imagenBase = new GreenfootImage("weaponized-ship-on.png");
            imagenBase.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
            actualizarImagen();
        }
    }

    /**
     * pre: los motores se encuentran encendidos
     * {@link NaveDeAtaque#motoresEncendidos} <br/>
     * post: apagará sus motores
     */
    public void apagarMotores() {
        if (this.motoresEncendidos) {
            this.motoresEncendidos = false;
            Greenfoot.playSound("engine-off.wav");
            int tamCelda = getWorld().getCellSize();
            imagenBase = new GreenfootImage("weaponized-ship.png");
            imagenBase.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
            actualizarImagen();
        }
    }

    /**
     * {@inheritDoc}
     */
    protected boolean puedeActuar() {
        return super.puedeActuar() && this.motoresEncendidos;
    }

    /**
     * {@inheritDoc} <br>
     * post: si se agota el {@link NaveAliada#combustible}, se apagarán los motores
     */
    protected void consumirCombustible(int cantidad) {
        super.consumirCombustible(cantidad);
        if (combustible <= 0) {
            this.apagarMotores();
        }
    }

    /**
     * pre: La NaveDeAtaque {@link #puedeActuar()} <br>
     * post: El {@link NaveAliada#combustible} se reducirá en
     * {@link #obtenerConsumoPorAtaque()}. Si en la dirección deseada hay un
     * {@link Dañable}, éste recibirá {@link #obtenerDaño()}.
     * 
     * @param direccion
     */
    public void atacarHacia(Direccion direccion) {
        if (!puedeActuar()) {
            return;
        }
        this.direccion = direccion;
        actualizarImagen();
        setRotation(direccion.rotacion);
        Greenfoot.delay(20);
        consumirCombustible(obtenerConsumoPorAtaque());

        Actor actor = getOneObjectAtOffset(this.direccion.dx, this.direccion.dy, Actor.class);
        if (!(actor instanceof Dañable)) {
            return;
        }
        Dañable objetivo = (Dañable) actor;
        if (objetivo != null) {
            Greenfoot.playSound("laser-shot.wav");
            objetivo.recibirDañoDe(this);
        }
    }

    /**
     * @see NaveAliada#moverHacia(Direccion)
     */
    public void avanzarHacia(Direccion direccion) {
        int xPrevio = this.getX();
        int yPrevio = this.getY();
        
        if (super.moverHacia(direccion)) {
            this.movimientos.add(direccion);
            this.direccion = direccion;
            actualizarEstela(xPrevio, yPrevio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int obtenerCombustible() {
        return super.obtenerCombustible();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    int obtenerCombustibleMaximo() {
        return 150;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int obtenerDaño() {
        return 35;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    int obtenerConsumoPorMovimiento() {
        return 7;
    }

    /**
     * @return la cantidad de combustible que consume realizar un ataque
     */
    int obtenerConsumoPorAtaque() {
        return 10;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean estaEnElBorde() {
        return super.estaEnElBorde();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hayVacioHacia(Direccion direccion) {
        return super.hayVacioHacia(direccion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hayAsteroideHacia(Direccion direccion) {
        return super.hayAsteroideHacia(direccion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hayItemHacia(Direccion direccion) {
        return super.hayItemHacia(direccion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hayNaveHacia(Direccion direccion) {
        return super.hayNaveHacia(direccion);
    }

    /**
     * pre: La NaveDeAtaque {@link #puedeActuar()} <br>
     * post: Obtiene la salud de una NaveDeAtaqueEnemiga o Asteroide, en
     * cierta Direccion.
     * 
     * @param direccion
     * @return la salud de una nave enemiga o el tamaño de un asteroide
     */
    public int escanearIndicadorHacia(Direccion direccion) {
        int valor = 0;
        if (hayNaveHacia(direccion)) {
            NaveDeAtaqueEnemiga nave = (NaveDeAtaqueEnemiga) getOneObjectAtOffset(direccion.dx, direccion.dy,
                    NaveDeAtaqueEnemiga.class);
            valor = nave.obtenerSalud();
        } else if (hayAsteroideHacia(direccion)) {
            Asteroide asteroide = (Asteroide) getOneObjectAtOffset(direccion.dx, direccion.dy, Asteroide.class);
            valor = asteroide.obtenerTamaño();
        }
        return valor;
    }

    public void recibirPiloto(PilotoBase piloto) {
        this.piloto = piloto;
        actualizarImagen();
    }

    public void bajarPiloto() {
        this.piloto = null;
        actualizarImagen();
    }

    @Override
    protected void actualizarImagen() {
        int tamCelda = getWorld().getCellSize();
        GreenfootImage image = getImage();
        image.scale((int) (tamCelda * ESCALA_X), (int) (tamCelda * ESCALA_Y));
        setImage(image);

        MyGreenfootImage canvas = new MyGreenfootImage(imagenBase.getWidth(),
                imagenBase.getHeight() + getWorld().getCellSize() / 3);

        canvas.setColor(Color.BLACK);
        canvas.fillRect(4, imagenBase.getHeight() - 2, getWorld().getCellSize() - 6, 12);
        canvas.setColor(obtenerColorDeBarraIndicadora());

        canvas.fillRect(6, imagenBase.getHeight(),
            (int) ((getWorld().getCellSize() - 10) * obtenerProporcionDeBarraIndicadora()), 8);

        canvas.rotate(360 - direccion.rotacion);

        canvas.drawImage(imagenBase, 0, getWorld().getCellSize() / 6);
        setImage(canvas);

        if (this.piloto != null) {
            canvas.highlight(this.piloto.getAura());
        }
    }

    private void actualizarEstela(int xPrevio, int yPrevio) {
        // La estela sirve para poder repasar el recorrido que realizó la nave, y de esa forma resolver errores.
        // Si deseas que la estela NO se dibuje, cambia este true por false
        if (true) {
            Color aura = this.piloto != null ? this.piloto.getAura() : MyGreenfootImage.AURAS[0];
            GreenfootImage fragmentoEstela = Estela.obtenerFragmentoEstela(this.movimientos, aura, getWorld());
            int tamCelda = getWorld().getCellSize();
            getWorld().getBackground().drawImage(fragmentoEstela, xPrevio * tamCelda, yPrevio * tamCelda);
        }
    }
}
