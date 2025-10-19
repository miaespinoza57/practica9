package practica9_1;

public class Posicion {
    private int renglon;
    private int columna;

    Posicion(int renglon, int columna) {
        this.columna = columna;
        this.renglon = renglon;
    }

    public int getRenglon() {
        return renglon;
    }

    public int getColumna() {
        return columna;
    }
}
