package practica9_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BombaTest {

    @Test
    public void testBomba() {
        // Crear escenario de prueba
        Escenario escenario = new Escenario("Test");
        Posicion pos = new Posicion(4, 5);

        // Crear Bomba con radio 2
        Bomba b = new Bomba(escenario, pos, 2);

        // 1️⃣ Verificar posición
        assertEquals(4, b.getPosicion().getRenglon());
        assertEquals(5, b.getPosicion().getColumna());

        // 2️⃣ Verificar radio
        assertEquals("Bomba 4 5 2", b.toConfigString());

        // 3️⃣ Verificar destruir
        assertEquals("Bomba destruida", b.destruir());

        // 4️⃣ Verificar que explotar no lanza excepción
        try {
            b.explotar();
        } catch (Exception e) {
            fail("El método explotar() lanzó una excepción:" + e.getMessage());
        }
    }
}
