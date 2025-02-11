import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculadoraDivision {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduzca el dividendo numero: ");
        int num1 = teclado.nextInt();

        System.out.println("Introduzca el divisor numero: ");
        int num2 = teclado.nextInt();

        int resultado = num1 / num2;

        DecimalFormat df = new DecimalFormat("#,###,##0");
        System.out.printf("La división de %s/%s = %s", df.format(num1), df.format(num2), df.format(resultado));
    }
}
