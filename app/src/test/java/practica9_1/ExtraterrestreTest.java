package practica9_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExtraterrestreTest {

    @Test
    public void testExtraterrestre() {
        // Crear escenario de prueba
        Escenario escenario = new Escenario("Test");
        Posicion pos = new Posicion(1, 2);

        Extraterrestre e = new Extraterrestre("Alien", escenario, pos);

        assertEquals(1, e.getPosicion().getRenglon());
        assertEquals(2, e.getPosicion().getColumna());

        assertEquals("Alien destruido", e.destruir());

        assertEquals("Extraterrestre 1 2", e.toConfigString());
    }
}
