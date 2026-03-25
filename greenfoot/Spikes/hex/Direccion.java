public enum Direccion {
    N(0,-1,+1), 
    NE(+1,-1,0), 
    SE(+1,0,-1),
    S(0, +1, -1),
    SO(-1,+1,0),
    NO(-1,0, +1);

    Hex delta;

    Direccion(int dq, int dr, int ds) {
        this.delta = new Hex(dq, dr, ds);
    }

    Hex getDelta() {
        return delta;
    }
}
