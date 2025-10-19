package practica9_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementoTest {

    @Test
    public void testJerarquiaElemento() {
        Escenario escenario = new Escenario("Test Jerarquía");
        Posicion pos = new Posicion(5, 5);

        // Test con Roca
        Roca roca = new Roca(escenario, pos);
        assertTrue(roca instanceof Elemento);
        assertEquals(5, roca.getPosition().getRenglon());
        assertEquals(5, roca.getPosition().getColumna());

        // Test con Terricola
        Terricola terricola = new Terricola("Soldado", escenario, pos);
        assertTrue(terricola instanceof Elemento);
        assertEquals(5, terricola.getPosition().getRenglon());
        assertEquals(5, terricola.getPosition().getColumna());

        // Test con Extraterrestre
        Extraterrestre alien = new Extraterrestre("Alien", escenario, pos);
        assertTrue(alien instanceof Elemento);
        assertEquals(5, alien.getPosition().getRenglon());
        assertEquals(5, alien.getPosition().getColumna());
    }

    @Test
    public void testPolimorfismoConElemento() {
        Escenario escenario = new Escenario("Test Polimorfismo");
        Posicion pos = new Posicion(3, 3);

        Elemento roca = new Roca(escenario, pos);
        Elemento terricola = new Terricola("Soldado", escenario, pos);
        Elemento alien = new Extraterrestre("Alien", escenario, pos);

        // Todos responden a getPosition()
        assertEquals(3, roca.getPosition().getRenglon());
        assertEquals(3, terricola.getPosition().getRenglon());
        assertEquals(3, alien.getPosition().getRenglon());

        // Todos pueden cambiar posición
        Posicion nuevaPos = new Posicion(7, 7);
        roca.setPosicion(nuevaPos);
        terricola.setPosicion(nuevaPos);
        alien.setPosicion(nuevaPos);

        assertEquals(7, roca.getPosition().getRenglon());
        assertEquals(7, terricola.getPosition().getRenglon());
        assertEquals(7, alien.getPosition().getRenglon());
    }

    @Test
    public void testDiferentesImplementacionesGetPosicion() {
        Escenario escenario = new Escenario("Test");
        Posicion pos = new Posicion(2, 2);

        Roca roca = new Roca(escenario, pos);
        Terricola terricola = new Terricola("Soldado", escenario, pos);
        Extraterrestre alien = new Extraterrestre("Alien", escenario, pos);

        // Todas las clases hijas implementan getPosicion() correctamente
        assertNotNull(roca.getPosicion());
        assertNotNull(terricola.getPosicion());
        assertNotNull(alien.getPosicion());

        assertEquals(2, roca.getPosicion().getRenglon());
        assertEquals(2, terricola.getPosicion().getRenglon());
        assertEquals(2, alien.getPosicion().getRenglon());
    }

    @Test
    public void testElementoEnEscenario() {
        Escenario escenario = new Escenario("Test");

        Elemento roca = new Roca(escenario, new Posicion(1, 1));
        Elemento terricola = new Terricola("Soldado", escenario, new Posicion(2, 2));
        Elemento alien = new Extraterrestre("Alien", escenario, new Posicion(3, 3));

        // Todos pueden ser agregados al escenario
        escenario.agregarElemento(roca);
        escenario.agregarElemento(terricola);
        escenario.agregarElemento(alien);

        String representacion = escenario.toString();
        assertTrue(representacion.contains("R ")); // Roca
        assertTrue(representacion.contains("T ")); // Terricola
        assertTrue(representacion.contains("E ")); // Extraterrestre
    }
}