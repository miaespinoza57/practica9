package practica9_1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BombaTest {
    @Test
    void testDestruir() {
        Escenario escenario = new Escenario("Prueba");
        Posicion pos = new Posicion(0, 0);
        Bomba bomba = new Bomba(escenario, pos, 5);

        assertEquals("Bomba destruida", bomba.destruir());
    }

    @Test
    void testExplotar() {
        Escenario escenario = new Escenario("Prueba");
        Posicion pos = new Posicion(0, 0);
        Bomba bomba = new Bomba(escenario, pos, 3);

        // Solo comprobamos que no lance excepción
        bomba.explotar();
    }

    @Test
    void testGetPosicion() {
        Escenario escenario = new Escenario("Prueba");
        Posicion pos = new Posicion(1, 2);
        Bomba bomba = new Bomba(escenario, pos, 4);

        assertEquals(pos, bomba.getPosicion());
    }
}
