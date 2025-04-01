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
                Pelicula peliculaSeleccionada = listado.getPeliculas().get(posicion-1);
                imprimirSubMenu();
                int opcionSubMenu = pedirEnteroTeclado("Ingrese una acción a realizar:");
                if(opcionSubMenu == 1){
                    String descripcion = pedirTextoTeclado("Descripción de la pelicula:");
                    descripcion = descripcion.isEmpty()? peliculaSeleccionada.descripcion() : descripcion;

                    int calificacion = pedirEnteroTeclado("Calificación de la pelicula:");
                    calificacion = calificacion <= 0? peliculaSeleccionada.calificacion() : calificacion;

                    String genero = pedirTextoTeclado("Genero de la pelicula:");
                    genero = genero.isEmpty()? peliculaSeleccionada.genero() : genero;

                    Pelicula peliculaActualizar = new Pelicula(peliculaSeleccionada.nombre(), descripcion, calificacion, genero);
                    listado.modificarPelicula(peliculaActualizar, posicion - 1);
                    System.out.println("Pelicula actuaizada!");
                }else if(opcionSubMenu == 2){
                    listado.eliminarPelicula(peliculaSeleccionada, posicion - 1);
                    System.out.println("Pelicula eliminada!");
                }
            }else if(opcion == 4){
                System.out.println("1. Si, Eliminar todo\n2. No.");
                int posicion = pedirEnteroTeclado("Está seguro que desea eliminar todas las peliculas, esta acción no se puede deshacer:");
                if(posicion == 1){
                    listado.eliminarTodasLasPeliculas();
                    System.out.println("Peliculas eliminadas!");
                }
            }
        }while (opcion != 5);
    }

    private static void imprimirMenu(){
        System.out.println("_____________________________________");
        System.out.println("Sistema de Gestión de Peliculas");
        System.out.println("1. Imprimir Peliculas");
        System.out.println("2. Agregar Peliculas");
        System.out.println("3. Seleccionar Pelicula");
        System.out.println("4. Eliminar Todas las Peliculas");
        System.out.println("5. Salir");
        System.out.println("_____________________________________");
    }

    private static void imprimirSubMenu(){
        System.out.println("_____________________________________");
        System.out.println("1. Modificar Pelicula");
        System.out.println("2. Eliminar Pelicula");
        System.out.println("3. Regresar");
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