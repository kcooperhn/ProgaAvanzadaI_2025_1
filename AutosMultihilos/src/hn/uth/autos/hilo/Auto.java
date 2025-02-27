package hn.uth.autos.hilo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Auto implements Runnable {

    //TODOS LOS HILOS DEBERIAN DE TENER SIEMPRE UN NOMBRE (BUENA PRACTICA)
    private String nombre;
    private static final int META = 100;
    private int distanciaRecorrida = 0;
    private int milisegunosEsperaMin = 200;
    private int probabilidadObstaculos = 5;
    //RANDOM SIRVE PARA GENERAR NUMEROS ALEATORIOS
    private Random rd = new Random();
    //PARA DETECTAR EL GANADOR DE LA CARRERA
    private static boolean carreraTerminada = false;
    //OBJETO USADO PARA BLOQUEO DE SINCRONIZACIÓN
    private static final Object lock = new Object();

    public Auto(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        //CONDICION DE EJECUCION
        while(distanciaRecorrida < META && !carreraTerminada) {
            sortearObstaculos();

            distanciaRecorrida += rd.nextInt(10) + 1; //GENERANDO NUMERO ENTRE 1 Y 10 ALEATORIO
            escribirProgreso();

            //SIMULA QUE EL CARRO SE ESTA MOVIENDO
            try {
                Thread.sleep(rd.nextInt(300) + milisegunosEsperaMin); //GENERA UN NUMERO ENTRE 200 Y 500
            } catch (InterruptedException e) {
                System.out.println("Error al ejecutar el hilo: " + e.getMessage());
                e.printStackTrace();
            }

            verificarGanador();
        }
    }

    private void sortearObstaculos() {
        if(rd.nextInt(100) < probabilidadObstaculos) {
            System.out.println("\"\uD83D\uDEA7 \" Cuidado! " + nombre+" ha encontrado un obstaculo en la carretera!");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Error al sortear un obstaculo: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    //VALIDA SI ALGUN OTRO CARRO YA LLEGO A LA META
    //TAMBIEN HACE USO DE UN RECURSO COMPARTIDO, POR LO QUE NECESITA
    //SINCRONIZACIÓN DE HILOS
    private void verificarGanador() {
        synchronized (lock) {
            if(!carreraTerminada && distanciaRecorrida >= META) {
                carreraTerminada = true;
                try(PrintWriter writer = new PrintWriter(new FileWriter("resultadosCarrera.txt", true))) {
                    writer.println(" \uD83C\uDFC6"+ nombre+" ha llegado a la meta y ganó la carrera! \uD83C\uDF89");
                }catch(Exception e){
                    System.out.println("Error al escribir el ganador: " + e.getMessage());
                    e.printStackTrace();
                }
                System.out.println(" \uD83C\uDFC6"+ nombre+" ha llegado a la meta y ganó la carrera! \uD83C\uDF89");
            }
        }
    }

    //PRUEBA DE CONCURRENCIA Y SOLUCIÓN CON SINCRONIZACIÓN DE HILOS
    //ACCEDIENDO A UN RECURSO COMPARTIDO POR TODOS LOS HILOS
    private void escribirProgreso() {
        synchronized (lock) {
            try(PrintWriter writer = new PrintWriter(new FileWriter("resultadosCarrera.txt", true))) {
                writer.println(" "+ nombre+" ha avanzado "+distanciaRecorrida +"km.");
            }catch(Exception e){
                System.out.println("Error al escribir el progreso: " + e.getMessage());
                e.printStackTrace();
            }
            System.out.println(" "+ nombre+" ha avanzado "+distanciaRecorrida +" km.");
        }

    }
}
