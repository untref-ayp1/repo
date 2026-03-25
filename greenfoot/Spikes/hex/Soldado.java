import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldado extends Actor {
    Direccion direccion = Direccion.SE;
    public Hex obtenerPosicion() {
        int x = this.getX();
        int y = this.getY();
        return ((MyWorld)getWorld()).getLayout().pixelToHex(new Point(x, y)).hexRound();
    }
    
    private Layout getLayout() {
        return ((MyWorld)getWorld()).getLayout();
    }
    
    public void avanzarHacia(Direccion direccion) {
        this.setDireccion(direccion);
        Hex to = obtenerPosicion().add(direccion.getDelta());
        Point nePo = getLayout().hexToPixel(to);
        this.setLocation((int)nePo.x, (int)nePo.y);
    }
    
    private void actualizarImagen() {
        int id = this.direccion.ordinal();
        GreenfootImage imagen = new GreenfootImage("footman" + id + ".png");
        setImage(imagen);
    }
    
    private void setDireccion(Direccion direccion) {
        this.direccion = direccion;
        actualizarImagen();
    }
    
    @Override
    public void addedToWorld(World world) {
        int x = this.getX();
        int y = this.getY();
        Layout layout = getLayout();
        Hex pos = layout.pixelToHex(new Point(x, y)).hexRound();
        
        Point nePo = layout.hexToPixel(pos);
        
        this.setLocation((int)nePo.x, (int)nePo.y);
    }
}
