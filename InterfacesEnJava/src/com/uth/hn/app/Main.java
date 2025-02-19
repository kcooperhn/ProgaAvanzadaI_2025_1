package com.uth.hn.app;

import com.uth.hn.Implementation.Rectangle;
import com.uth.hn.Interface.Shape;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio de Interfaces");
        System.out.println("Probando Interfaz Shape (Rectangle)");

        //FORMA CORRECTA DE IMPLEMENTAR UNA INTERFAZ
        //PRIMERO INTERFAZ, LUEGO IMPLEMENTACIÓN
        //INTERFAZ {nombreVariable} = new IMPLEMENTACION
        Shape r1 = new Rectangle(4, 10);

        //CASTING DE INTERFACES
        //ES UNA CONVERSIÓN DEL TIPO DE UNA INTERFAZ A OTRA
        ((Rectangle)r1).imprimirDatos();
        r1.draw();

        r1.zoom();

        ((Rectangle)r1).imprimirDatos();
        r1.draw();

        //FORMA INCORRECTA PERO QUE FUNCIONA
        Rectangle r2 = new Rectangle(4,2);

        r2.imprimirDatos();
    }
}