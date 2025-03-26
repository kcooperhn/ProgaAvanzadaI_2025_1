package com.peliculas.entidades;

import com.peliculas.bd.BaseDatos;

import java.util.List;

public class ListadoPeliculas {
    private List<Pelicula> peliculas;
    private BaseDatos bd;

    public ListadoPeliculas(){
        bd = new BaseDatos();
        peliculas = bd.consultarPeliculas();
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void agregarPelicula(Pelicula pelicula) {
        this.peliculas.add(pelicula);
        this.bd.crearPelicula(pelicula);
    }

   public void imprimirPeliculas(){
        int indice = 1;
        for (Pelicula pelicula : peliculas) {
            System.out.println("____________________________________________________");
            System.out.println("PELICULA: "+indice++);
            System.out.println(pelicula);
        }
        System.out.println();
   }

   public void imprimirPelicula(int posicion){
        if(posicion >= 0 && posicion < peliculas.size()){
            Pelicula seleccionada = peliculas.get(posicion-1);

            System.out.println("____________________________________________________");
            System.out.println("\tNombre: "+seleccionada.nombre());
            System.out.println("\tDescripción: "+seleccionada.descripcion());
            System.out.println("\tCalificación: "+seleccionada.calificacion());
            System.out.println("\tGenero: "+seleccionada.genero());
            System.out.println(" ");
        }else{
            System.err.println("No existe el pelicula con el id "+posicion);
        }
   }
}
