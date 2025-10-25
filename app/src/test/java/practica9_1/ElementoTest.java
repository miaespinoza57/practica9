package practica9_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

// Clase concreta de prueba para poder instanciar Elemento
class ElementoConcreto extends Elemento {
    public ElementoConcreto(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
    }

    @Override
    protected Posicion getPosicion() {
        return super.posicion;
    }

    @Override
    protected String toConfigString() {
        return "ElementoConcreto " + posicion.getRenglon() + " " + posicion.getColumna();
    }
}

public class ElementoTest {

    private Escenario escenario;
    private ElementoConcreto elemento;
    private Posicion posicion;

    @BeforeEach
    void setUp() {
        escenario = new Escenario("Test");
        posicion = new Posicion(3, 5);
        elemento = new ElementoConcreto(escenario, posicion);
    }

    @Test
    void testCreacionElemento() {
        assertNotNull(elemento);
        assertSame(escenario, elemento.escenario); // protected field accessible in same package
    }

    @Test
    void testGetPosicion() {
        Posicion posicionObtenida = elemento.getPosicion();

        assertNotNull(posicionObtenida);
        assertEquals(3, posicionObtenida.getRenglon());
        assertEquals(5, posicionObtenida.getColumna());
        assertSame(posicion, posicionObtenida);
    }

    @Test
    void testSetPosicion() {
        Posicion nuevaPosicion = new Posicion(7, 2);
        elemento.setPosicion(nuevaPosicion);

        Posicion posicionActualizada = elemento.getPosicion();
        assertEquals(7, posicionActualizada.getRenglon());
        assertEquals(2, posicionActualizada.getColumna());
        assertSame(nuevaPosicion, posicionActualizada);
    }

    @Test
    void testToConfigString() {
        String configString = elemento.toConfigString();

        assertNotNull(configString);
        assertTrue(configString.contains("ElementoConcreto"));
        assertTrue(configString.contains("3"));
        assertTrue(configString.contains("5"));
        assertEquals("ElementoConcreto 3 5", configString);
    }

    @Test
    void testGetPosition() {
        // Test del método público getPosition()
        Posicion pos = elemento.getPosition();

        assertNotNull(pos);
        assertEquals(3, pos.getRenglon());
        assertEquals(5, pos.getColumna());
    }

    @Test
    void testSetPosicionConNull() {
        // Test para verificar comportamiento con posición null
        elemento.setPosicion(null);

        assertNull(elemento.getPosicion());
    }

    @Test
    void testElementoConDiferentesPosiciones() {
        // Test con diferentes valores de posición
        Posicion[] posiciones = {
                new Posicion(0, 0),
                new Posicion(9, 9),
                new Posicion(5, 5)
        };

        for (Posicion pos : posiciones) {
            ElementoConcreto elem = new ElementoConcreto(escenario, pos);
            assertEquals(pos.getRenglon(), elem.getPosicion().getRenglon());
            assertEquals(pos.getColumna(), elem.getPosicion().getColumna());
        }
    }
}