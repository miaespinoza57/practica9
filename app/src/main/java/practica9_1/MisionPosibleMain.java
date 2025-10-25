package practica9_1;

import java.util.*;
import java.io.*;

public class MisionPosibleMain {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Escenario e = new Escenario("Nostromo");

        // Lista para guardar las bombas y poder detonarlas
        List<Bomba> bombas = new ArrayList<>();

        List<String> lineas = leerArchivo("app/src/main/java/practica9_1/config.txt");
        for (String linea : lineas) {
            String[] datos = linea.split(" ");
            String tipo = datos[0];

            switch (tipo) {
                case "Terricola":
                    e.agregarElemento(new Terricola(
                            "Terricola",
                            e,
                            new Posicion(Integer.parseInt(datos[1]), Integer.parseInt(datos[2]))));
                    break;
                case "Extraterrestre":
                    e.agregarElemento(new Extraterrestre(
                            "Extraterrestre",
                            e,
                            new Posicion(Integer.parseInt(datos[1]), Integer.parseInt(datos[2]))));
                    break;
                case "Roca":
                    e.agregarElemento(new Roca(
                            e,
                            new Posicion(Integer.parseInt(datos[1]), Integer.parseInt(datos[2]))));
                    break;
                case "Bomba":
                    Bomba b = new Bomba(
                            e,
                            new Posicion(Integer.parseInt(datos[1]), Integer.parseInt(datos[2])),
                            Integer.parseInt(datos[3]));
                    e.agregarElemento(b);
                    bombas.add(b);
                    break;
            }
        }

        System.out.println("=== ESCENARIO INICIAL ===");
        System.out.println(e);
        System.out.println("Ingrese la fila de la bomba a detonar:");
        int filaB = leer.nextInt();
        System.out.println("Ingrese la columna de la bomba a detonar:");
        int colB = leer.nextInt();

        boolean detonada = false;
        for (Bomba b : bombas) {
            if (b.getPosicion().getRenglon() == filaB && b.getPosicion().getColumna() == colB) {
                b.explotar();
                detonada = true;
                break;
            }
        }

        if (!detonada) {
            System.out.println("No se encontró ninguna bomba en esa posición.");
        }
        System.out.println("=== ESCENARIO ACTUAL ===");
        System.out.println(e);

        List<String> nuevaConfig = e.generarConfiguracion();
        escribirArchivo("app/src/main/java/practica9_1/config.txt", nuevaConfig);

        System.out.println("Configuración actualizada guardada en el archivo.");
    }

    // Método para leer archivo
    public static List<String> leerArchivo(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();
        try {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                System.out.println("ERROR: Archivo no encontrado: " + archivo.getAbsolutePath());
                return lineas;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    lineas.add(linea.trim());
                }
            }
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }
        return lineas;
    }

    // Método para escribir archivo
    public static void escribirArchivo(String nombreArchivo, List<String> lineas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Error al escribir el archivo: " + ex.getMessage());
        }
    }
}
