package practica9_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Clase concreta para testear Personaje
class PersonajeConcreto extends Personaje {
    public PersonajeConcreto(String nombre, Escenario e, Posicion p) {
        super(nombre, e, p);
    }

    @Override
    public String destruir() {
        return nombre + " destruido desde clase concreta";
    }

    @Override
    public Posicion getPosicion() {
        return posicion;
    }
}

public class PersonajeTest {
    private Escenario escenario;
    private PersonajeConcreto personaje;

    @BeforeEach
    public void setUp() {
        escenario = new Escenario("Escenario Test");
        personaje = new PersonajeConcreto("Heroe", escenario, new Posicion(3, 3));
    }

    @Test
    public void testCreacionPersonaje() {
        assertNotNull(personaje);
        assertEquals("Heroe", personaje.getNombre());
        assertEquals(10, personaje.puntosDeVida); // Asumiendo que es accesible
    }

    @Test
    public void testGetNombre() {
        assertEquals("Heroe", personaje.getNombre());
    }

    @Test
    public void testPuntosDeVidaInicial() {
        assertEquals(10, personaje.puntosDeVida);
    }

    @Test
    public void testPersonajeEsDestruible() {
        assertTrue(personaje instanceof Destruible);
    }

    @Test
    public void testPersonajeEsElemento() {
        assertTrue(personaje instanceof Elemento);
    }

    @Test
    public void testGetPosicion() {
        Posicion pos = personaje.getPosicion();
        assertNotNull(pos);
        assertEquals(3, pos.getRenglon());
        assertEquals(3, pos.getColumna());
    }
}