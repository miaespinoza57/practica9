
package practica9_1;

public abstract class Elemento {
    protected Posicion posicion;
    protected Escenario escenario;

    Elemento(Escenario e, Posicion p) {
        escenario = e;
        posicion = p;
    }

    public Posicion getPosition() {
        return posicion;
    }

    public void setPosicion(Posicion p) {
        posicion = p;
    }

    protected abstract Posicion getPosicion();

    protected abstract String toConfigString();

}
