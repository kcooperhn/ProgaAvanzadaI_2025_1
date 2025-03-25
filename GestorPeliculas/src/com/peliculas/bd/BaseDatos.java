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
            conexion = DriverManager.getConnection("jdbc:ucanaccess://C:/bd/gestor_peliculas.accdb"); //ESTA LINEA SE DEBERIA DE CAMBIAR PARA ELEGIR OTRA TECNOLOGIA DE BD
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
}
