package practica9_1;

import java.util.ArrayList;

public class Escenario {
    private String nombre;
    private Elemento[][] campoDeBatalla;

    public Escenario(String nombre) {
        this.nombre = nombre;
        campoDeBatalla = new Elemento[10][10];
    }

    public void agregarElemento(Elemento e) {
        Posicion p = e.getPosicion();
        int fila = p.getRenglon();
        int col = p.getColumna();
        if (fila >= 0 && fila < 10 && col >= 0 && col < 10) {
            campoDeBatalla[fila][col] = e;
        }
    }

    public void destruirElementos(Posicion centro, int radio) {
        ArrayList<Elemento> enRango = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Elemento e = campoDeBatalla[i][j];
                if (e != null) {
                    if (estaEnRango(e.getPosicion(), centro, radio)) {
                        enRango.add(e);
                    }
                }
            }
        }

        for (Elemento e : enRango) {
            if (e instanceof Destruible) {
                System.out.println(((Destruible) e).destruir());
                Posicion p = e.getPosicion();
                campoDeBatalla[p.getRenglon()][p.getColumna()] = null;
            }
        }
    }

    private boolean estaEnRango(Posicion p, Posicion centro, int radio) {
        int dx = Math.abs(p.getRenglon() - centro.getRenglon());
        int dy = Math.abs(p.getColumna() - centro.getColumna());
        return dx <= radio && dy <= radio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Escenario: ").append(nombre).append("\n");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Elemento e = campoDeBatalla[i][j];
                if (e == null)
                    sb.append(". ");
                else if (e instanceof Terricola)
                    sb.append("T ");
                else if (e instanceof Extraterrestre)
                    sb.append("E ");
                else if (e instanceof Roca)
                    sb.append("R ");
                else if (e instanceof Bomba)
                    sb.append("B ");
                else
                    sb.append("? ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
