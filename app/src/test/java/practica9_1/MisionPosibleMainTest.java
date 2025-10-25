package practica9_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MisionPosibleMainTest {

    @TempDir
    Path tempDir;

    private File configFile;

    @BeforeEach
    void setUp() throws IOException {
        // Crear archivo de configuración de prueba
        configFile = new File(tempDir.toFile(), "config.txt");

        List<String> contenido = Arrays.asList(
                "Terricola 1 1",
                "Extraterrestre 3 3",
                "Roca 2 2",
                "Bomba 4 4 2");

        Files.write(configFile.toPath(), contenido);
    }

    @Test
    void testLeerArchivo() {
        // Prueba que el método leerArchivo funciona correctamente
        List<String> lineas = MisionPosibleMain.leerArchivo(configFile.getAbsolutePath());

        assertFalse(lineas.isEmpty(), "El archivo debería tener líneas");
        assertEquals(4, lineas.size(), "Debería haber 4 líneas en el archivo");
        assertEquals("Terricola 1 1", lineas.get(0), "Primera línea incorrecta");
    }

    @Test
    void testLeerArchivoNoExiste() {
        // Prueba con archivo que no existe
        List<String> lineas = MisionPosibleMain.leerArchivo("archivo_que_no_existe.txt");

        assertTrue(lineas.isEmpty(), "Debería retornar lista vacía para archivo inexistente");
    }

    @Test
    void testEscribirArchivo() {
        // Prueba el método escribirArchivo
        List<String> datos = Arrays.asList("Linea 1", "Linea 2", "Linea 3");
        File archivoSalida = new File(tempDir.toFile(), "salida_test.txt");

        MisionPosibleMain.escribirArchivo(archivoSalida.getAbsolutePath(), datos);

        assertTrue(archivoSalida.exists(), "El archivo de salida debería existir");

        // Verificar contenido
        List<String> lineasLeidas = MisionPosibleMain.leerArchivo(archivoSalida.getAbsolutePath());
        assertEquals(3, lineasLeidas.size(), "Debería tener 3 líneas");
        assertEquals("Linea 1", lineasLeidas.get(0), "Contenido incorrecto");
    }

    @Test
    void testProcesamientoConfiguracion() {
        // Simula el procesamiento del archivo de configuración
        List<String> lineas = MisionPosibleMain.leerArchivo(configFile.getAbsolutePath());

        Escenario escenario = new Escenario("Test");
        List<Bomba> bombas = new ArrayList<>();

        for (String linea : lineas) {
            String[] datos = linea.split(" ");
            String tipo = datos[0];

            switch (tipo) {
                case "Terricola":
                    Terricola t = new Terricola("Terricola", escenario,
                            new Posicion(Integer.parseInt(datos[1]), Integer.parseInt(datos[2])));
                    escenario.agregarElemento(t);
                    break;
                case "Bomba":
                    Bomba b = new Bomba(escenario,
                            new Posicion(Integer.parseInt(datos[1]), Integer.parseInt(datos[2])),
                            Integer.parseInt(datos[3]));
                    escenario.agregarElemento(b);
                    bombas.add(b);
                    break;
            }
        }

        assertNotNull(escenario, "El escenario debería crearse correctamente");
        assertEquals(1, bombas.size(), "Debería haber 1 bomba en la lista");
    }
}