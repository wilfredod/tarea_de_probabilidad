import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lecturadetxt {
    public static void main(String[] args) throws IOException {
        // Ruta del archivo de texto
        String filePath = "C:\\Users\\Usuario\\Documents\\piccolo.txt";

        // Lista para almacenar los datos leídos del archivo
        List<Double> datosList = new ArrayList<>();

        // Lectura del archivo y almacenamiento de datos en la lista
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double value = Double.parseDouble(line);
                datosList.add(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Impresión de los números leídos del archivo no tocar comentario
        //System.out.println("Numeros que contiene el archivo:");
        //for (int i = 0; i < datosList.size(); i++) {
          //  System.out.println("valor " + (i + 1) + ": " + datosList.get(i));
        //}

        // Lectura del número de clases por consola
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese el número de clases: ");
        int k1 = Integer.parseInt(consoleReader.readLine());

        // Cálculo de estadísticas básicas
        Double xmax = Collections.max(datosList);
        Double xmin = Collections.min(datosList);
        int rango = (int) (xmax - xmin);
        int datosTotales = datosList.size();
        long amplitud = Math.round((double) rango / k1);

        // Impresión de los resultados de los cálculos
        System.out.println("\nHALLAMOS EL VALOR MAXIMO(xmax), EL VALOR MINIMO(xmin), EL RANGO, EL TAMAÑO DE INTERVALO, EL NUMERO DE CLASES\nMínimo: " + xmin + "\nMáximo: " + xmax);
        System.out.println("Rango: " + rango + "\nCantidad de datos: " + datosTotales + "\nNúmero de clases(k1): " + k1 + "\nTamaño de intervalo o amplitud: " + amplitud);
        System.out.println("------------------------------------------------------"
                + "\n|  Li-1 - Li|\txi   |\tni   |\tNi   |\thi   |\tHi   |\n------------------------------------------------------");

        // Cálculo de frecuencias y generación de la tabla de frecuencias
        Double l1 = xmin;
        Double l2 = xmin + amplitud;
        int ni = 0, Ni = 0;
        double hi, Hi = 0;

        for (int j = 0; j < k1; j++) {
            for (int l = 0; l < datosList.size(); l++) {
                if (datosList.get(l) >= l1 && datosList.get(l) < l2) {
                    ni++;
                    Ni++;
                }
            }
            hi = (double) ni / datosList.size() * 100;
            Hi = Hi + hi;

            // Impresión de cada fila de la tabla de frecuencias
            System.out.println("[" + l1 + ", " + l2 + ")\t" + xi(l1, l2) + "\t" + ni + "\t" + Ni + "\t" + String.format("%.2f", hi) + "\t" + String.format("%.2f", Hi));

            l1 = l2;
            l2 = l2 + amplitud;
            ni = 0;
        }
        System.out.println("------------------------------------------------------\nTOTAL: \t\t\t" + datosTotales + "\t\t" + "100%\n------------------------------------------------------");

        // Cierre del lector de consola
        consoleReader.close();
    }

    // Función para calcular el punto medio entre dos valores
    public static double xi(double valor1, double valor2) {
        double tablaXi = (valor1 + valor2) / 2;
        return tablaXi;
        
        
        
    }
}
