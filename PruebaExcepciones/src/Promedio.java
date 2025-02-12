import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Promedio {
    public static void main(String[] args) {

        List<Calificacion> calificaciones = new ArrayList<>();
        int opt = 0;
        do {
            imprimirMenu();
            opt = solicitarNumeroTeclado("Ingrese la opción a realizar: ");

            if(opt == 1){
                calificaciones.add(solicitarCalificacion());
            }else if(opt == 2){
                System.out.println("--------------------------------");
                calificaciones.forEach(System.out::println);
                System.out.println("--------------------------------");
            }else if(opt == 3){
                System.out.println("--------------------------------");
                int prom = 0;
                for(Calificacion cal: calificaciones){
                    prom += cal.calificacion();
                }
                prom = prom/calificaciones.size();
                System.out.println("El promedio es: "+prom);
            }

        }while(opt != 0);
    }

    private static Calificacion solicitarCalificacion(){
        String nombre = solicitarTextoTeclado("Nombre del Alumno:");
        String apellido = solicitarTextoTeclado("Apellido del Alumno:");
        String cuenta = solicitarTextoTeclado("Cuenta del Alumno:");
        String asignatura = solicitarTextoTeclado("Asignatura cursando:");
        int calificacion = solicitarNumeroTeclado("Calificacion Obtenida:");
        return new Calificacion(new Alumno(nombre, apellido, cuenta), asignatura, calificacion);
    }

    private static void imprimirMenu() {
        System.out.println("1. Ingresar Calificacion");
        System.out.println("2. Imprimir listado de calificaciones");
        System.out.println("3. Calcular Promedio");
        System.out.println("0. Salir");
    }

    private static String solicitarTextoTeclado(String mensaje) {
        Scanner teclado = new Scanner(System.in);

        System.out.println(mensaje);
        return teclado.nextLine();
    }

    private static int solicitarNumeroTeclado(String mensaje) {
        Scanner teclado = new Scanner(System.in);

        System.out.println(mensaje);
        return teclado.nextInt();
    }


}
