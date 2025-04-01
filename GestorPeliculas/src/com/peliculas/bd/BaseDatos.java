package com.peliculas.bd;

import com.peliculas.entidades.Pelicula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BaseDatos {

    private Connection conexion;

    public BaseDatos(){
        this.conexion = null;
    }

    private PreparedStatement conectar(String operacionSQL){
        PreparedStatement operacion = null;
        try{
            if(conexion != null){
                conexion.close();
            }
            conexion = DriverManager.getConnection("jdbc:ucanaccess://C:/projects/bd/gestor_peliculas.accdb"); //ESTA LINEA SE DEBERIA DE CAMBIAR PARA ELEGIR OTRA TECNOLOGIA DE BD
            operacion = conexion.prepareStatement(operacionSQL);

        }catch(Exception e){
            System.err.println("Error al conectarse a la base de datos.");
            System.err.println(e.getLocalizedMessage());
        }
        return operacion;
    }

    public List<Pelicula> consultarPeliculas(){
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try{
            PreparedStatement operacion = conectar("SELECT * FROM peliculas");
            ResultSet rs = operacion.executeQuery(); //AQUI SE EJECUTA LA OPERACION CONTRA LA BASE DE DATOS
            Pelicula peli;
            while(rs.next()){
                peli = new Pelicula(rs.getString("nombre"), rs.getString("descripcion"),
                        rs.getInt("calificacion"),rs.getString("genero"));
                peliculas.add(peli);
            }
        }catch (Exception e){
            System.err.println("Error al consultar las peliculas.");
            System.err.println(e.getLocalizedMessage());
        }
        return peliculas;
    }

    public void crearPelicula(Pelicula nueva){
        try{
            PreparedStatement operacion = conectar("INSERT INTO peliculas (nombre, descripcion, calificacion, genero) VALUES (?, ?, ?, ?) ");
            operacion.setString(1, nueva.nombre());
            operacion.setString(2, nueva.descripcion());
            operacion.setInt(3, nueva.calificacion());
            operacion.setString(4, nueva.genero());

            operacion.executeUpdate(); //EJECUTE CAMBIOS EN LA BASE DE DATOS
            conexion.commit();//GUARDAR
            conexion.close();//CIERRO LA CONEXION
        }catch (Exception e){
            System.err.println("Error al crear una pelicula.");
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void modificarPelicula(Pelicula peliculaActualizar) {
        try{
            PreparedStatement operacion = conectar("UPDATE peliculas SET descripcion = ?, calificacion = ?, genero = ? WHERE nombre = ?");
            operacion.setString(1, peliculaActualizar.descripcion());
            operacion.setInt(2, peliculaActualizar.calificacion());
            operacion.setString(3, peliculaActualizar.genero());
            operacion.setString(4, peliculaActualizar.nombre());

            operacion.executeUpdate(); //EJECUTE CAMBIOS EN LA BASE DE DATOS
            conexion.commit();//GUARDAR
            conexion.close();//CIERRO LA CONEXION
        }catch (Exception e){
            System.err.println("Error al actualizar una pelicula.");
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void eliminarPelicula(Pelicula peliculaSeleccionada) {
        try{
            PreparedStatement operacion = conectar("DELETE FROM peliculas WHERE nombre = ?");
            operacion.setString(1, peliculaSeleccionada.nombre());

            operacion.executeUpdate(); //EJECUTE CAMBIOS EN LA BASE DE DATOS
            conexion.commit();//GUARDAR
            conexion.close();//CIERRO LA CONEXION
        }catch (Exception e){
            System.err.println("Error al borrar una pelicula.");
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void eliminarTodasLasPeliculas() {
        try{
            PreparedStatement operacion = conectar("DELETE FROM peliculas");

            operacion.executeUpdate(); //EJECUTE CAMBIOS EN LA BASE DE DATOS
            conexion.commit();//GUARDAR
            conexion.close();//CIERRO LA CONEXION
        }catch (Exception e){
            System.err.println("Error al borrar una pelicula.");
            System.err.println(e.getLocalizedMessage());
        }
    }
}
