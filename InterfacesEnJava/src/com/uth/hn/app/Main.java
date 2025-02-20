package com.uth.hn.app;

import com.uth.hn.Implementation.Rectangle;
import com.uth.hn.Implementation.Triangle;
import com.uth.hn.Interface.Shape;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio de Interfaces");
        System.out.println("Probando Interfaz Shape (Rectangle)");

        //FORMA CORRECTA DE IMPLEMENTAR UNA INTERFAZ
        //PRIMERO INTERFAZ, LUEGO IMPLEMENTACIÓN
        //INTERFAZ {nombreVariable} = new IMPLEMENTACION
        Shape r1 = new Rectangle(4, 10);
        r1.imprimirNombre();
        //CASTING DE INTERFACES
        //ES UNA CONVERSIÓN DEL TIPO DE UNA INTERFAZ A OTRA
        //((Rectangle)r1).imprimirDatos();
        r1.draw();

        r1.zoom();
        r1.zoom();
        r1.zoom();

        r1.imprimirNombre();
        //((Rectangle)r1).imprimirDatos();
        r1.draw();

        System.out.println("Generando Rectangulo con valores negativos");
        Shape r3 = new Rectangle(-4, -8);
        r3.imprimirNombre();
        r3.draw();


        //PROBANDO SEGUNDA IMPLEMENTACIÓN DE SHAPE
        System.out.println("Probando Interfaz Shape (Triangle)");
        Shape t1 = new Triangle(7);
        Shape t2 = new Triangle(7);



        //Triangle t2 = (Triangle)t1;

        t1.imprimirNombre();
        t1.draw();
        t1.zoom();
        t1.zoom();

        t1.imprimirNombre();
        t1.draw();

        //Opcion 1, usando Casting
        ((Triangle)t1).compareTo((Triangle)t2);


        //Opcion 2 Creando instancias temporales
        Triangle t3 = (Triangle)t1;
        Triangle t4 = (Triangle) t2;
        t3.imprimirNombre();
        t4.imprimirNombre();

        int result = t3.compareTo(t4);
        System.out.println("¿Los triangulos son iguales? "+result+ (result <= 0 ?"Si":"No"));


    }
}