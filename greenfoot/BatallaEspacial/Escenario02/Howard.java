import greenfoot.*;

class Howard extends PilotoBase {
    void probarNave(NaveDeAtaque nave) {
        subirse(nave);
        nave.encenderMotores();
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.SUR);
        nave.avanzarHacia(Direccion.SUR);
        nave.avanzarHacia(Direccion.NORTE);
        nave.apagarMotores();
        bajarse();
    }

    void probarNave2(NaveDeAtaque nave) {
        despegar(nave);
        maniobrar(nave);
        aterrizar(nave);
    }
    
    void despegar(NaveDeAtaque nave) {
        subirse(nave);
        nave.encenderMotores();
    }
    
    void maniobrar(NaveDeAtaque nave) {
        nave.avanzarHacia(Direccion.NORTE);
        nave.avanzarHacia(Direccion.SUR);
        nave.avanzarHacia(Direccion.SUR);
        nave.avanzarHacia(Direccion.NORTE);
    }
    
    void aterrizar(NaveDeAtaque nave) {
        nave.apagarMotores();
        bajarse();
    }
    
}
