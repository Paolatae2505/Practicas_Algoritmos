
import java.util.Scanner;
/**
 * Clase Main
 * @author Vargas Bravo Paola
 * @version 1.0 (10 Dic 2022)
 * @since Analsis de Algortimos (2023-1)
 * @see leerTXT
 */

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LeerTXT leerTXT;
        System.out.println("Digite la ruta de su grafica (archivo terminacion txt) :");
        String path = entrada.nextLine();
        leerTXT = new LeerTXT(path);
        leerTXT.inicializarGrafica();
    }
}
