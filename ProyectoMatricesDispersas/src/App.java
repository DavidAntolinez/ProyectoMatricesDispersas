import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int [][]  m= Matriz();
        
        Forma1 c = new Forma1(m);
        c.Mostrar();
    }

    public static int[][] Matriz(){
        Random aleatorio = new Random();
        int f = aleatorio.nextInt(10)+1;
        int c = aleatorio.nextInt(10)+1;
        int[][]  matriz = new int[3][4];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                boolean bandera = aleatorio.nextBoolean();
                if(bandera){
                    int N = aleatorio.nextInt(100)+1;
                    matriz[i][j] = N;
                }
            }
        }
        return matriz;
    }

}
