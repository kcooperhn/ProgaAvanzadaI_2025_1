import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AlgoritmoListas {
    public static void main(String[] args) {
        System.out.println("Leyendo contenido archivo: primero.txt");
        List<String> contenido1 = leerArchivo("C:\\projects\\archivos_ejercicio\\primero.txt");
        contenido1.forEach(System.out::print);
        System.out.println("");

        System.out.println("Leyendo contenido archivo: segundo.txt");
        List<String> contenido2 = leerArchivo("C:\\projects\\archivos_ejercicio\\segundo.txt");
        contenido2.forEach(System.out::print);
        System.out.println("");

        double numero1 = convertirNumero(contenido1);
        double numero2 = convertirNumero(contenido2);
        double resultado = numero1 + numero2;
        DecimalFormat df = new DecimalFormat("#,###,##0");
        System.out.printf("El resultado es: (%s + %s = %s)", df.format(numero1), df.format(numero2), df.format(resultado));
    }

    private static List<String> leerArchivo(String archivo) {
        List<String> contenido = new ArrayList<>();
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(archivo));
            String linea = null;
            do{
                linea = br.readLine();
                if(linea != null){
                    contenido.add(linea);
                }
            } while(linea != null);
            br.close();
        }catch(FileNotFoundException errorArchivoNoEncontrado){
            System.out.println("No se encontro el archivo");
        }catch (IOException errorArchivoCorrupto){
            System.out.println("Error al leer el archivo");
        }
        return contenido;
    }

    private static double convertirNumero(List<String> valores){
        double numero = 0;
        // v*10^i = n
        try{
            int contador = 0;
            for (String v : valores) {
                numero += Integer.parseInt(v) * Math.pow(10, contador);
                contador++;
            }
        }catch(NumberFormatException error){
            System.out.println("Error al convertir el numero. Error: " + error.getMessage());
        }
        return numero;
    }
}
