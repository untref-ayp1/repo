public class Piloto00 extends PilotoBase {

    @Override
    public void subirse(NaveDeAtaque nave) {
        super.subirse(nave);
    }

    @Override
    public void bajarse() {
        super.bajarse();
    }

    void despegar() {
        navePilotada.encenderMotores();
    }

    void avanzarAlNortePor(int casilleros) {
        for (int pasos = 0; pasos < casilleros; pasos++) {
            navePilotada.avanzarHacia(Direccion.NORTE);
        }
    }

    int destruirAsteroideHacia(Direccion direccion) {
        int ataques = 0;
        while (navePilotada.hayAsteroideHacia(direccion)) {
            navePilotada.atacarHacia(direccion);
            ataques++;
        }
        return ataques;
    }

    void llegarALaBaseNorte() {
        avanzarAlNortePor(5);
        destruirAsteroideHacia(Direccion.NORTE);
        avanzarAlNortePor(3);
    }
    
    int avanzarHastaAsteroideHacia(Direccion direccion) {
        int contador = 0;
        while(!navePilotada.hayAsteroideHacia(direccion)) {
            navePilotada.avanzarHacia(direccion);
            contador++;
        }
        return contador;
    }
    
    void avanzarHaciaPor(Direccion direccion, int pasos) {
        for(int i = 1; i <= pasos; i++) {
            navePilotada.avanzarHacia(direccion);
        }
    }
    
    void irAlAsteroideVolver(Direccion direccion) {
        int pasos = avanzarHastaAsteroideHacia(direccion);
        avanzarHaciaPor(direccion.opuesta(), pasos);
    }
}
