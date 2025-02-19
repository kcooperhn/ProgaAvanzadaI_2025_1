package com.uth.hn.Implementation;

import com.uth.hn.Interface.Shape;

public class Rectangle implements Shape {

    private int alto;
    private int ancho;

    public Rectangle(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override
    public void draw() {
        if (alto > 0 && ancho > 0 && alto != ancho) {
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    // Imprimir bordes superior e inferior
                    if (i == 0 || i == alto - 1 || j == 0 || j == ancho - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("El rectángulo debe tener dimensiones mayores a 0x0 y no ser un cuadrado.");
        }
    }

    @Override
    public void zoom() {
        System.out.println("Haciendo zoom a la figura");
        this.alto += 1;
        this.ancho += 1;
    }

    //ESTA FUNCION SOLO EXISTE EN LA IMPLEMENTACION
    public int calcularArea(){
        return alto * ancho;
    }

    //ESTA FUNCION SOLO EXISTE EN LA IMPLEMENTACION
    public void imprimirDatos(){
        System.out.println("\nDatos del Rectangulo");
        System.out.println("----------------------");
        System.out.println("Alto: " + this.alto);
        System.out.println("Ancho: " + this.ancho);
        System.out.println("----------------------\n");
    }
}
