package hn.uth.autos;

import hn.uth.autos.hilo.Auto;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String [] autos = new String[]{" Auto Rojo", " Auto Azul"," Auto Verde", " Auto Negro", " Auto Rosa", " Auto Rosa2", " Auto Rosa3"," Auto Rosa4"," Auto morado"," Auto cafe"," Auto blanco"," Auto celeste"," Auto Amarillo"};

        System.out.println("\uD83D\uDEA6 COMIENZA LA CARRERA \uD83D\uDEA6");

        try(PrintWriter writer = new PrintWriter(new FileWriter("resultadosCarrera.txt", true))) {
            writer.println("\uD83D\uDEA6 COMIENZA LA CARRERA \uD83D\uDEA6");
        }catch(Exception e){
            System.out.println("Error al escribir el inicio: " + e.getMessage());
            e.printStackTrace();
        }

        for (int i = 0; i < autos.length; i++) {
            Thread auto = new Thread(new Auto(autos[i] + "("+(i+1) +")\t"));
            auto.start();
        }
    }
}