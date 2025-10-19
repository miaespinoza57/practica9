package practica9_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExtraterrestreTest {
    private Escenario escenario;
    private Extraterrestre extraterrestre;

    @BeforeEach
    public void setUp() {
        escenario = new Escenario("Escenario Test");
        extraterrestre = new Extraterrestre("Alien", escenario, new Posicion(5, 5));
    }

    @Test
    public void testCreacionExtraterrestre() {
        assertNotNull(extraterrestre);
    }

    @Test
    public void testGetPosicion() {
        Posicion posicion = extraterrestre.getPosicion();
        assertNotNull(posicion);
        assertEquals(5, posicion.getRenglon());
        assertEquals(5, posicion.getColumna());
    }

    @Test
    public void testDestruir() {
        String resultadoDestruccion = extraterrestre.destruir();
        assertEquals("Alien destruido", resultadoDestruccion);
    }

    @Test
    public void testExtraterrestreEnEscenario() {
        escenario.agregarElemento(extraterrestre);

        String representacionEscenario = escenario.toString();
        assertTrue(representacionEscenario.contains("E ")); // Debería aparecer como "E"
    }

    @Test
    public void testMultipleExtraterrestres() {
        Extraterrestre et1 = new Extraterrestre("ET1", escenario, new Posicion(0, 0));
        Extraterrestre et2 = new Extraterrestre("ET2", escenario, new Posicion(9, 9));

        escenario.agregarElemento(et1);
        escenario.agregarElemento(et2);

        String representacion = escenario.toString();
        // Debería haber dos "E" en el escenario
        assertTrue(representacion.contains("E "));
    }

    @Test
    public void testExtraterrestreEsDestruible() {
        assertTrue(extraterrestre instanceof Destruible);
    }

    @Test
    public void testDestruccionEnEscenario() {
        escenario.agregarElemento(extraterrestre);

        // Verificar que está en el escenario
        String escenarioInicial = escenario.toString();
        assertTrue(escenarioInicial.contains("E "));

        // Destruir el extraterrestre
        escenario.destruirElementos(new Posicion(5, 5), 1);

        // Verificar que fue destruido (depende de tu implementación)
        // Esto podría verificarse si el elemento ya no está en esa posición
    }
}