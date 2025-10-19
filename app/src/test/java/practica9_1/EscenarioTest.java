package practica9_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EscenarioTest {
    private Escenario escenario;

    @BeforeEach
    public void setUp() {
        escenario = new Escenario("Escenario de Prueba");
    }

    @Test
    public void testCreacionEscenario() {
        assertNotNull(escenario);
        assertEquals("Escenario: Escenario de Prueba", escenario.toString().split("\n")[0]);
    }

    @Test
    public void testAgregarElementoValido() {
        Posicion pos = new Posicion(5, 5);
        Roca roca = new Roca(escenario, pos);
        escenario.agregarElemento(roca);
        // No hay excepción - éxito
    }

    @Test
    public void testAgregarElementoFueraDeRango() {
        Posicion posFuera = new Posicion(15, 15);
        Roca roca = new Roca(escenario, posFuera);
        escenario.agregarElemento(roca);
        // No debería agregarse pero no debe lanzar excepción
    }

    @Test
    public void testToStringEscenarioVacio() {
        String resultado = escenario.toString();
        assertTrue(resultado.contains("Escenario: Escenario de Prueba"));
    }

    public void testEscenarioConElementos() {
        // Agregar diferentes tipos de elementos
        escenario.agregarElemento(new Terricola("wil", escenario, new Posicion(0, 0)));
        escenario.agregarElemento(new Extraterrestre("wil", escenario, new Posicion(9, 9)));

        String resultado = escenario.toString();

        assertTrue(resultado.contains("T ")); // Terricola en (0,0)
        assertTrue(resultado.contains("E ")); // Extraterrestre en (9,9)
        assertTrue(resultado.contains("R ")); // Roca en (5,5)
        assertTrue(resultado.contains("B ")); // Bomba en (2,3)
    }

    @Test
    public void testDestruirElementos() {
        // Crear elementos destruibles
        Roca roca1 = new Roca(escenario, new Posicion(3, 3));
        Roca roca2 = new Roca(escenario, new Posicion(7, 7));

        escenario.agregarElemento(roca1);
        escenario.agregarElemento(roca2);

        // Destruir elementos en un radio alrededor de (5,5)
        Posicion centro = new Posicion(5, 5);
        escenario.destruirElementos(centro, 2);

        // Los elementos dentro del radio deberían ser destruidos
    }
}