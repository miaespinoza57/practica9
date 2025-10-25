package practica9_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class EscenarioTest {

    private Escenario escenario;
    private Terricola terricola;
    private Extraterrestre extraterrestre;
    private Roca roca;
    private Bomba bomba;

    @BeforeEach
    void setUp() {
        escenario = new Escenario("Nostromo");

        // Crear elementos de prueba
        terricola = new Terricola("Terricola", escenario, new Posicion(1, 1));
        extraterrestre = new Extraterrestre("Extraterrestre", escenario, new Posicion(3, 3));
        roca = new Roca(escenario, new Posicion(5, 5));
        bomba = new Bomba(escenario, new Posicion(7, 7), 2);
    }

    @Test
    void testCreacionEscenario() {
        assertTrue(escenario.toString().contains("Nostromo"));
        assertNotNull(escenario.getElementos());
        assertTrue(escenario.getElementos().isEmpty());
    }

    @Test
    void testAgregarElemento() {
        escenario.agregarElemento(terricola);
        escenario.agregarElemento(extraterrestre);

        List<Elemento> elementos = escenario.getElementos();
        assertEquals(2, elementos.size());
        assertTrue(elementos.contains(terricola));
        assertTrue(elementos.contains(extraterrestre));
    }

    @Test
    void testAgregarElementoFueraDeRango() {
        // Intentar agregar elemento en posición fuera del rango
        Terricola fueraDeRango = new Terricola("Fuera", escenario, new Posicion(15, 15));
        escenario.agregarElemento(fueraDeRango);

        // No debería agregarse a la lista
        assertTrue(escenario.getElementos().isEmpty());
    }

    @Test
    void testGenerarConfiguracion() {
        // Agregar elementos
        escenario.agregarElemento(terricola);
        escenario.agregarElemento(roca);
        escenario.agregarElemento(bomba);

        List<String> configuracion = escenario.generarConfiguracion();

        assertEquals(3, configuracion.size());
        assertTrue(configuracion.get(0).contains("Terricola"));
        assertTrue(configuracion.get(1).contains("Roca"));
        assertTrue(configuracion.get(2).contains("Bomba"));
    }

    @Test
    void testToStringVacio() {
        String resultado = escenario.toString();

        assertTrue(resultado.contains("Escenario: Nostromo"));
        // Debería mostrar solo puntos (casillas vacías)
        assertTrue(resultado.contains(". . . . . . . . . ."));
    }

    @Test
    void testToStringConElementos() {
        escenario.agregarElemento(terricola);
        escenario.agregarElemento(extraterrestre);
        escenario.agregarElemento(roca);
        escenario.agregarElemento(bomba);

        String resultado = escenario.toString();

        assertTrue(resultado.contains("T ")); // Terricola
        assertTrue(resultado.contains("E ")); // Extraterrestre
        assertTrue(resultado.contains("R ")); // Roca
        assertTrue(resultado.contains("B ")); // Bomba
    }

    @Test
    void testDestruirElementos() {
        // Agregar elementos destructibles
        escenario.agregarElemento(terricola); // Destruible
        escenario.agregarElemento(extraterrestre); // Destruible
        escenario.agregarElemento(roca); // Destruible
        escenario.agregarElemento(bomba); // No destruible

        int elementosIniciales = escenario.getElementos().size();

        // Destruir elementos en radio 2 desde posición (2,2)
        escenario.destruirElementos(new Posicion(2, 2), 2);

        // Terricola en (1,1) y Extraterrestre en (3,3) deberían destruirse
        // Roca en (5,5) está fuera del radio
        // Bomba no es destruible
        List<Elemento> elementosRestantes = escenario.getElementos();

        // Deberían quedar la roca (fuera de rango) y la bomba (no destruible)
        assertTrue(elementosRestantes.size() < elementosIniciales);
        assertTrue(elementosRestantes.contains(roca));
        assertTrue(elementosRestantes.contains(bomba));
    }

    @Test
    void testDestruirElementosFueraDeRango() {
        escenario.agregarElemento(terricola);
        escenario.agregarElemento(roca);

        int elementosIniciales = escenario.getElementos().size();

        // Intentar destruir desde posición lejana (radio pequeño)
        escenario.destruirElementos(new Posicion(8, 8), 1);

        // No debería destruirse ningún elemento
        assertEquals(elementosIniciales, escenario.getElementos().size());
    }

    @Test
    void testMultiplesElementosMismaPosicion() {
        // Al agregar un elemento en una posición ocupada, debería reemplazarlo
        Terricola terricola1 = new Terricola("T1", escenario, new Posicion(0, 0));
        Terricola terricola2 = new Terricola("T2", escenario, new Posicion(0, 0));

        escenario.agregarElemento(terricola1);
        escenario.agregarElemento(terricola2);

        // Solo debería quedar el último elemento agregado
        assertEquals(2, escenario.getElementos().size());
    }
}