package hn.uth.lambdas;

import hn.uth.abstracciones.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int opcion = 0;
        List<Libro> libros = new ArrayList<Libro>();
        do {
            imprimirMenu();
            opcion = solicitarNumeroTelcado("Ingrese la opción del Menu:");
            if(opcion == 1){
                String titulo = solicitarTextoTelcado("Ingrese el titulo:");
                String autor = solicitarTextoTelcado("Ingrese el nombre del autor:");
                int fechaPublicacion = solicitarNumeroTelcado("Ingrese la fecha de publicación:");
                String editorial = solicitarTextoTelcado("Ingrese el nombre de la editorial:");

                libros.add(new Libro(titulo, autor, fechaPublicacion, editorial));
            }else if(opcion == 2){
                String autorBuscado = solicitarTextoTelcado("Ingrese el nombre del autor a filtrar:");

                //HAGO USO DE FUNCIONES LAMBDA EN METODO FILTER
                List<Libro> resultadoBusqueda = libros.stream().filter(libro -> libro.autor().equalsIgnoreCase(autorBuscado)).collect(Collectors.toList());
                // (PARAMETROS) -> { CODIGO; }

                //USO DE FUNCION LAMBDA PARA RECORRER EL RESULTADO
                resultadoBusqueda.forEach(libro -> System.out.println("Libro encontrado:\t"+libro+"\n"));
            }else if(opcion == 3){
                String editorialBuscada = solicitarTextoTelcado("Ingrese el nombre de la editorial:");

                //HAGO USO DE FUNCIONES LAMBDA EN METODO FILTER
                List<Libro> resultadoBusqueda = libros.stream().filter(libro -> libro.editorial().equalsIgnoreCase(editorialBuscada)).collect(Collectors.toList());
                // (PARAMETROS) -> { CODIGO; }

                //USO DE FUNCION LAMBDA PARA RECORRER EL RESULTADO
                resultadoBusqueda.forEach(libro -> System.out.println("Libro encontrado:\t"+libro+"\n"));
            }else if(opcion == 4){
                //USO DE FUNCION LAMBDA PARA RECORRER EL RESULTADO
                libros.forEach(System.out::println);
            }
        }while (opcion != 5);
    }

    private static void imprimirMenu(){
        System.out.println("*** SISTEMA DE BIBLIOTECA ***");
        System.out.println("1. Registrar Libro");
        System.out.println("2. Listar Libros por autor");
        System.out.println("3. Listar Libros por editorial");
        System.out.println("4. Listar todos los libros");
        System.out.println("5. Salir");
        System.out.println("******************************\n");
    }

    private static String solicitarTextoTelcado(String mensaje){
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    private static int solicitarNumeroTelcado(String mensaje){
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }
}