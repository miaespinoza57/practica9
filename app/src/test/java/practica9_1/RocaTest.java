package practica9_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RocaTest {
    private Escenario escenario;
    private Roca roca;

    @BeforeEach
    public void setUp() {
        escenario = new Escenario("Escenario Test");
        roca = new Roca(escenario, new Posicion(3, 4));
    }

    @Test
    public void testCreacionRoca() {
        assertNotNull(roca);
    }

    @Test
    public void testGetPosicion() {
        Posicion posicion = roca.getPosicion();
        assertNotNull(posicion);
        assertEquals(3, posicion.getRenglon());
        assertEquals(4, posicion.getColumna());
    }

    @Test
    public void testRocaEsElemento() {
        assertTrue(roca instanceof Elemento);
    }

    @Test
    public void testRocaNoEsDestruible() {
        // Roca NO implementa Destruible, a diferencia de los Personajes
        assertFalse(roca instanceof Destruible);
    }

    @Test
    public void testRocaEnEscenario() {
        escenario.agregarElemento(roca);
        String representacion = escenario.toString();
        assertTrue(representacion.contains("R ")); // Debería aparecer como "R"
    }

    @Test
    public void testMultiplesRocas() {
        Roca roca1 = new Roca(escenario, new Posicion(0, 0));
        Roca roca2 = new Roca(escenario, new Posicion(5, 5));
        Roca roca3 = new Roca(escenario, new Posicion(9, 9));

        escenario.agregarElemento(roca1);
        escenario.agregarElemento(roca2);
        escenario.agregarElemento(roca3);

        String representacion = escenario.toString();
        // Debería haber múltiples "R" en el escenario
        assertTrue(representacion.contains("R "));
    }

    @Test
    public void testRocasEnDiferentesPosiciones() {
        Roca roca1 = new Roca(escenario, new Posicion(1, 1));
        Roca roca2 = new Roca(escenario, new Posicion(8, 2));

        Posicion pos1 = roca1.getPosicion();
        Posicion pos2 = roca2.getPosicion();

        assertEquals(1, pos1.getRenglon());
        assertEquals(1, pos1.getColumna());
        assertEquals(8, pos2.getRenglon());
        assertEquals(2, pos2.getColumna());
    }

    @Test
    public void testRocaConPosicionNegativa() {
        Roca rocaNegativa = new Roca(escenario, new Posicion(-1, -1));
        Posicion pos = rocaNegativa.getPosicion();
        assertEquals(-1, pos.getRenglon());
        assertEquals(-1, pos.getColumna());
    }

    @Test
    public void testRocaConPosicionFueraEscenario() {
        Roca rocaFuera = new Roca(escenario, new Posicion(15, 15));
        Posicion pos = rocaFuera.getPosicion();
        assertEquals(15, pos.getRenglon());
        assertEquals(15, pos.getColumna());

        // Aunque la posición está fuera del escenario, la roca se puede crear
        escenario.agregarElemento(rocaFuera);
        // No debería lanzar excepción
    }

    @Test
    public void testSetPosicion() {
        // Asumiendo que tienes setPosicion en Elemento
        Posicion nuevaPosicion = new Posicion(7, 8);
        roca.setPosicion(nuevaPosicion);

        Posicion posActual = roca.getPosicion();
        assertEquals(7, posActual.getRenglon());
        assertEquals(8, posActual.getColumna());
    }
}
