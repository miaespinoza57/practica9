package practica9_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PosicionTest {

    @Test
    public void testCreacionPosicion() {
        Posicion posicion = new Posicion(5, 3);
        assertNotNull(posicion);
    }

    @Test
    public void testGetRenglon() {
        Posicion posicion = new Posicion(5, 3);
        assertEquals(5, posicion.getRenglon());
    }

    @Test
    public void testGetColumna() {
        Posicion posicion = new Posicion(5, 3);
        assertEquals(3, posicion.getColumna());
    }

    @Test
    public void testPosicionConValoresCero() {
        Posicion posicion = new Posicion(0, 0);
        assertEquals(0, posicion.getRenglon());
        assertEquals(0, posicion.getColumna());
    }

    @Test
    public void testPosicionConValoresMaximos() {
        Posicion posicion = new Posicion(9, 9);
        assertEquals(9, posicion.getRenglon());
        assertEquals(9, posicion.getColumna());
    }

    @Test
    public void testPosicionesDiferentes() {
        Posicion pos1 = new Posicion(2, 3);
        Posicion pos2 = new Posicion(7, 8);

        assertEquals(2, pos1.getRenglon());
        assertEquals(3, pos1.getColumna());
        assertEquals(7, pos2.getRenglon());
        assertEquals(8, pos2.getColumna());
    }

    @Test
    public void testPosicionNegativa() {
        Posicion posicion = new Posicion(-1, -5);
        assertEquals(-1, posicion.getRenglon());
        assertEquals(-5, posicion.getColumna());
    }

    @Test
    public void testPosicionGrande() {
        Posicion posicion = new Posicion(100, 200);
        assertEquals(100, posicion.getRenglon());
        assertEquals(200, posicion.getColumna());
    }

    @Test
    public void testMultipleInstancias() {
        Posicion pos1 = new Posicion(1, 1);
        Posicion pos2 = new Posicion(2, 2);
        Posicion pos3 = new Posicion(3, 3);

        assertNotSame(pos1, pos2);
        assertNotSame(pos2, pos3);
        assertNotSame(pos1, pos3);

        assertEquals(1, pos1.getRenglon());
        assertEquals(1, pos1.getColumna());
        assertEquals(2, pos2.getRenglon());
        assertEquals(2, pos2.getColumna());
        assertEquals(3, pos3.getRenglon());
        assertEquals(3, pos3.getColumna());
    }
}