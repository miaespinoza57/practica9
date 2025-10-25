package practica9_1;

public class Bomba extends Elemento implements Destruible {
    private int radio;

    public Bomba(Escenario e, Posicion p, int r) {
        super(e, p);
        this.radio = r;
    }

    public void explotar() {
        System.out.println("Explotando bomba!!");
        escenario.destruirElementos(posicion, radio);
    }

    @Override
    public String destruir() {
        return "Bomba destruida";
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    public String toConfigString() {
        return "Bomba " + posicion.getRenglon() + " " + posicion.getColumna() + " " + radio;
    }
}
