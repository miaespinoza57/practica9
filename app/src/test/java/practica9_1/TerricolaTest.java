package practica9_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TerricolaTest {
    private Escenario escenario;
    private Terricola terricola;

    @BeforeEach
    public void setUp() {
        escenario = new Escenario("Escenario Test");
        terricola = new Terricola("Soldado", escenario, new Posicion(3, 4));
    }

    @Test
    public void testCreacionTerricola() {
        assertNotNull(terricola);
        assertEquals("Soldado", terricola.getNombre());
        assertEquals(10, terricola.puntosDeVida);
    }

    @Test
    public void testGetPosicion() {
        Posicion posicion = terricola.getPosicion();
        assertNotNull(posicion);
        assertEquals(3, posicion.getRenglon());
        assertEquals(4, posicion.getColumna());
    }

    @Test
    public void testDestruir() {
        String resultadoDestruccion = terricola.destruir();
        assertEquals("Soldado (Terrícola) destruido", resultadoDestruccion);
    }

    @Test
    public void testTerricolaEnEscenario() {
        escenario.agregarElemento(terricola);
        String representacion = escenario.toString();
        assertTrue(representacion.contains("T ")); // Debería aparecer como "T"
    }

    @Test
    public void testMultipleTerricolas() {
        Terricola t1 = new Terricola("Soldado1", escenario, new Posicion(0, 0));
        Terricola t2 = new Terricola("Soldado2", escenario, new Posicion(5, 5));
        Terricola t3 = new Terricola("Marine", escenario, new Posicion(9, 9));

        assertEquals("Soldado1", t1.getNombre());
        assertEquals("Soldado2", t2.getNombre());
        assertEquals("Marine", t3.getNombre());
        assertEquals(10, t1.puntosDeVida);
        assertEquals(10, t2.puntosDeVida);
        assertEquals(10, t3.puntosDeVida);
    }

    @Test
    public void testTerricolaEsPersonaje() {
        assertTrue(terricola instanceof Personaje);
    }

    @Test
    public void testTerricolaEsElemento() {
        assertTrue(terricola instanceof Elemento);
    }

    @Test
    public void testTerricolaEsDestruible() {
        assertTrue(terricola instanceof Destruible);
    }

    @Test
    public void testHerenciaDeAtributos() {
        // Verificar que hereda correctamente los atributos de Personaje
        assertEquals("Soldado", terricola.getNombre());
        assertEquals(10, terricola.puntosDeVida);

        Posicion pos = terricola.getPosicion();
        assertEquals(3, pos.getRenglon());
        assertEquals(4, pos.getColumna());
    }

    @Test
    public void testDiferentesNombres() {
        Terricola t1 = new Terricola("Comandante", escenario, new Posicion(1, 1));
        Terricola t2 = new Terricola("Francotirador", escenario, new Posicion(2, 2));
        Terricola t3 = new Terricola("Médico", escenario, new Posicion(3, 3));

        assertEquals("Comandante", t1.getNombre());
        assertEquals("Francotirador", t2.getNombre());
        assertEquals("Médico", t3.getNombre());
    }

    @Test
    public void testDestruirConDiferentesNombres() {
        Terricola comandante = new Terricola("Comandante", escenario, new Posicion(1, 1));
        Terricola medico = new Terricola("Médico", escenario, new Posicion(2, 2));

        assertEquals("Comandante (Terrícola) destruido", comandante.destruir());
        assertEquals("Médico (Terrícola) destruido", medico.destruir());
    }
}
