package practica9_1;

public class Terricola extends Personaje {

    public Terricola(String nombre, Escenario e, Posicion p) {
        super(nombre, e, p);
    }

    @Override
    public String destruir() {
        return nombre + " (Terrícola) destruido";
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    public String toConfigString() {
        return "Terricola " + posicion.getRenglon() + " " + posicion.getColumna();
    }
}
