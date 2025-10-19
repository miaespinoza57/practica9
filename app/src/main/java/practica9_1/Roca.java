package practica9_1;

public class Roca extends Elemento {
    public Roca(Escenario e, Posicion p) {
        super(e, p);
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }
}
