package practica9_1;

public abstract class Personaje extends Elemento implements Destruible {
    protected String nombre;
    protected int puntosDeVida;

    public Personaje(String nombre, Escenario e, Posicion p) {
        super(e, p);
        this.nombre = nombre;
        this.puntosDeVida = 10;
    }

    public String getNombre() {
        return nombre;
    }

}
