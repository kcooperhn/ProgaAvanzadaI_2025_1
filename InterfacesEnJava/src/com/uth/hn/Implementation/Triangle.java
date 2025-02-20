package com.uth.hn.Implementation;

import com.uth.hn.Interface.Shape;

public class Triangle implements Shape, Comparable<Triangle> {
    private int altura;

    public Triangle(int altura) {
        if(Shape.esValido(altura)){
            this.altura = altura;
        }else{
            throw new ArithmeticException("Altura Invalida");
        }

    }

    @Override
    public void draw() {
        if(altura < 2){
            System.out.println("El triangulo debe de tener una altura mayor a 2");
        }else{
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < altura - i - 1; j++) {
                    System.out.print(" ");
                }

                //esto imprime el borde del triangulo
                for (int j = 0; j < 2 * i + 1; j++) {
                    if(j == 0 || j== 2 * i || i == altura - 1 ){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }

                }
                System.out.println();
            }
        }
    }

    @Override
    public void zoom() {
        this.altura += 2;
    }

    //ESTA FUNCION SOLO EXISTE EN LA IMPLEMENTACION
    private void imprimirDatos(){
        System.out.println("\nDatos del Triangulo");
        System.out.println("----------------------");
        System.out.println("Altura: " + this.altura);
        System.out.println("----------------------\n");
    }

    @Override
    public void imprimirNombre(){
        Shape.super.imprimirNombre();
        imprimirDatos();
    }

    @Override
    public int compareTo(Triangle other) {
        return Integer.compare(this.altura, other.altura);
    }
}
