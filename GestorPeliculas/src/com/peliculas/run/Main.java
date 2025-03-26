package com.peliculas.run;

import com.peliculas.entidades.ListadoPeliculas;
import com.peliculas.entidades.Pelicula;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListadoPeliculas listado = new ListadoPeliculas();
        int opcion = 0;
        do {
            imprimirMenu();
            opcion = pedirEnteroTeclado("Ingrese una opción del menú:");
            if(opcion == 1){
                listado.imprimirPeliculas();
            }else if(opcion == 2){
                String nombre = pedirTextoTeclado("Nombre de la pelicula:");
                String descripcion = pedirTextoTeclado("Descripción de la pelicula:");
                int calificacion = pedirEnteroTeclado("Calificación de la pelicula:");
                String genero = pedirTextoTeclado("Genero de la pelicula:");

                Pelicula nuevaPelicula = new Pelicula(nombre, descripcion, calificacion, genero);
                listado.agregarPelicula(nuevaPelicula);
            }else if(opcion == 3){
                listado.imprimirPeliculas();
                int posicion = pedirEnteroTeclado("Ingrese el número de pelicula a imprimir:");
                listado.imprimirPelicula(posicion);
            }

        }while (opcion != 5);
    }

    private static void imprimirMenu(){
        System.out.println("_____________________________________");
        System.out.println("Sistema de Gestión de Peliculas");
        System.out.println("1. Imprimir Peliculas");
        System.out.println("2. Agregar Peliculas");
        System.out.println("3. Seleccionar Pelicula");
        System.out.println("4. Eliminar Pelicula");
        System.out.println("5. Salir");
        System.out.println("_____________________________________");
    }

    private static int pedirEnteroTeclado(String mensaje){
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static String pedirTextoTeclado(String mensaje){
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }
}