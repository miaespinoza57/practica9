package practica9_1;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MisionPosibleMainTest {

    @Test
    void testMainEjecutaSinErroresYProduceSalida() {
        // Redirigir la salida estándar a un stream temporal
        ByteArrayOutputStream salidaConsola = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salidaConsola));

        // Ejecutar el main
        assertDoesNotThrow(() -> MisionPosibleMain.main(new String[] {}));

        // Obtener la salida
        String salida = salidaConsola.toString();

        // Verificar que haya impreso el escenario
        assertTrue(salida.contains("Escenario: Nostromo"), "Debe mostrar el nombre del escenario");

        // Verificar que haya impreso alguna representación de los elementos (T, E, R,
        // B)
        assertTrue(
                salida.contains("T ") || salida.contains("E ") || salida.contains("R ") || salida.contains("B "),
                "Debe mostrar al menos un elemento en el escenario");

        // Verificar que haya ocurrido la explosión de la bomba
        assertTrue(salida.toLowerCase().contains("explota") || salida.toLowerCase().contains("destruido"),
                "Debe mostrar que la bomba explotó o destruyó elementos");

        // Restaurar salida estándar (opcional, buena práctica)
        System.setOut(System.out);
    }
}
