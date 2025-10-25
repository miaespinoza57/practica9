package practica9_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TerricolaTest {

    @Test
    public void testTerricola() {
        // Crear escenario de prueba
        Escenario escenario = new Escenario("Test");
        Posicion pos = new Posicion(2, 3);

        // Crear Terricola
        Terricola t = new Terricola("Ripley", escenario, pos);

        assertEquals(2, t.getPosicion().getRenglon());
        assertEquals(3, t.getPosicion().getColumna());

        assertEquals("Ripley (Terrícola) destruido", t.destruir());

        assertEquals("Terricola 2 3", t.toConfigString());
    }
}
