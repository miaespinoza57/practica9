package practica9_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RocaTest {

    @Test
    public void testRoca() {
        // Crear escenario de prueba
        Escenario escenario = new Escenario("Test");
        Posicion pos = new Posicion(5, 6);

        // Crear Roca
        Roca r = new Roca(escenario, pos);

        assertEquals(5, r.getPosicion().getRenglon());
        assertEquals(6, r.getPosicion().getColumna());

        assertEquals("Roca 5 6", r.toConfigString());
    }
}
