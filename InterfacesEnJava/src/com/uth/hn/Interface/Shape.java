package com.uth.hn.Interface;

public interface Shape {
    default void imprimirNombre(){
       System.out.println("Imprimiendo datos de la figura");
    }

    static boolean esValido(int valor){
        return valor > 0;
    }
    void draw();
    void zoom();
}
