import java.util.Scanner;

public class Tripletas {
    private int tripleta[][];
    Scanner Basura = new Scanner(System.in);

    public Tripletas() {
    }

    public Tripletas(int[][] Matriz) {
        int i = 0;
        int j = 0;
        int cont = 0;
        for (; i < Matriz.length; i++) {
            j = 0;
            for (; j < Matriz[i].length; j++) {
                if (Matriz[i][j] != 0) {
                    cont++;
                }
            }
        }
        int Tripleta[][] = new int[cont + 1][3];
        Tripleta[0][0] = i;
        Tripleta[0][1] = j;
        Tripleta[0][2] = cont;
        cont = 1;
        for (int k = 0; k < Matriz.length; k++) {
            for (int k2 = 0; k2 < Matriz[k].length; k2++) {
                if (Matriz[k][k2] != 0) {
                    Tripleta[cont][0] = k;
                    Tripleta[cont][1] = k2;
                    Tripleta[cont][2] = Matriz[k][k2];
                    cont++;
                }
            }
        }
        tripleta = Tripleta;
    }

    public void Mostrar() {
        for (int i = 0; i < tripleta.length; i++) {
            for (int j = 0; j < tripleta[i].length; j++) {
                System.out.print("[" + tripleta[i][j] + "]");
            }
            System.out.println();
        }
    }

    public int[][] getTripleta() {
        return tripleta;
    }

    public void setTripleta(int[][] tripleta) {
        this.tripleta = tripleta;
    }

    public void Sumar(Tripletas b) {
        if (tripleta[0][0] == b.tripleta[0][0] && b.tripleta[0][1] == tripleta[0][1]) {
            int k = 1;
            int i = 1;
            int j = 1;
            Tripletas c = new Tripletas();
            c.tripleta = new int[tripleta[0][2] + b.tripleta[0][2]][3];
            while (i < tripleta.length || j < b.tripleta.length) {
                if (i < tripleta.length && j < b.tripleta.length) {
                    if (tripleta[i][0] == b.tripleta[j][0] && b.tripleta[j][1] == tripleta[i][1]) {
                        if (tripleta[i][2] + b.tripleta[j][2] != 0) {
                            c.tripleta[k][0] = tripleta[i][0];
                            c.tripleta[k][1] = tripleta[i][1];
                            c.tripleta[k][2] = tripleta[i][2] + b.tripleta[j][2];

                            k++;
                        }
                        j++;
                        i++;
                    } else {
                        if (tripleta[i][0] == b.tripleta[j][0] && b.tripleta[j][1] > tripleta[i][1]) {
                            c.tripleta[k][0] = tripleta[i][0];
                            c.tripleta[k][1] = tripleta[i][1];
                            c.tripleta[k][2] = tripleta[i][2];
                            k++;
                            i++;
                        } else if (tripleta[i][0] == b.tripleta[j][0] && b.tripleta[j][1] < tripleta[i][1]) {
                            c.tripleta[k][0] = b.tripleta[j][0];
                            c.tripleta[k][1] = b.tripleta[j][1];
                            c.tripleta[k][2] = b.tripleta[j][2];
                            k++;
                            j++;
                        } else if (tripleta[i][0] > b.tripleta[j][0]) {
                            c.tripleta[k][0] = b.tripleta[j][0];
                            c.tripleta[k][1] = b.tripleta[j][1];
                            c.tripleta[k][2] = b.tripleta[j][2];
                            k++;
                            j++;
                        } else {
                            c.tripleta[k][0] = tripleta[i][0];
                            c.tripleta[k][1] = tripleta[i][1];
                            c.tripleta[k][2] = tripleta[i][2];
                            k++;
                            i++;
                        }
                    }
                } else if (i < tripleta.length) {
                    c.tripleta[k][0] = tripleta[i][0];
                    c.tripleta[k][1] = tripleta[i][1];
                    c.tripleta[k][2] = tripleta[i][2];
                    k++;
                    i++;
                } else {
                    c.tripleta[k][0] = b.tripleta[j][0];
                    c.tripleta[k][1] = b.tripleta[j][1];
                    c.tripleta[k][2] = b.tripleta[j][2];
                    k++;
                    j++;
                }
            }
            c.tripleta[0][0] = tripleta[0][0];
            c.tripleta[0][1] = tripleta[0][1];
            c.tripleta[0][2] = k - 1;
            c.Redimensionar();
            c.Mostrar();
        } else {
            System.out.println("Las matrices son de diferente tamaño, no se pueden sumar");
        }
    }

    public void Redimensionar() {
        Tripletas nuevo = new Tripletas();
        nuevo.tripleta = new int[tripleta[0][2] + 1][3];
        for (int i = 0; i < nuevo.tripleta.length; i++) {
            nuevo.tripleta[i][0] = tripleta[i][0];
            nuevo.tripleta[i][1] = tripleta[i][1];
            nuevo.tripleta[i][2] = tripleta[i][2];
        }
        tripleta = nuevo.tripleta;
    }

    
    public void Eliminar() {
        System.out.println("ingrese 1, 2 o 3 si quieres eliminar por dato, posicion o posicion y dato respectivamente");
        int opc = Basura.nextInt();
        boolean bandera = false;
        switch (opc) {
            case 1:
                System.out.println("ingrese el dato a eliminar");
                int dato = Basura.nextInt();
                for (int i = 1; i < tripleta.length; i++) {
                    if (tripleta[i][2] == dato) {
                        bandera = true;
                        for(int j = i;j+1<tripleta.length;j++){
                            tripleta[j][0] = tripleta[j+1][0];
                            tripleta[j][1] = tripleta[j+1][1];
                            tripleta[j][2] = tripleta[j+1][2];
                        }
                        tripleta[0][2]--;
                    }
                }
                break;
            case 2:
                System.out.println("ingrese primero las filas, y luego las columnas, ejemplo: (1,2) uno es las filas y dos las columnas");
                String cadena = Basura.next();
                String[] componentes = cadena.split(",");
                if(Integer.parseInt(componentes[0]) < tripleta[0][0] && Integer.parseInt(componentes[1]) < tripleta[0][1]){
                   for (int i = 1; i < tripleta.length; i++) {
                        if(Integer.parseInt(componentes[0]) == tripleta[i][0] && Integer.parseInt(componentes[1]) == tripleta[i][1]){
                            bandera = true;
                            for(int j = i;j+1<tripleta.length;j++){
                            tripleta[j][0] = tripleta[j+1][0];
                            tripleta[j][1] = tripleta[j+1][1];
                            tripleta[j][2] = tripleta[j+1][2];
                            }
                            tripleta[0][2]--;
                            i = tripleta.length;
                        }
                   }
                }
                
                break;
            case 3:
                System.out.println("ingrese primero las filas, luego las columnas, y por ultimo el dato, ejemplo: (1,2,3) uno es las filas, dos las columnas y 3 el dato");
                 cadena = Basura.next();
                String[] comp = cadena.split(",");
                if(Integer.parseInt(comp[0]) < tripleta[0][0] && Integer.parseInt(comp[1]) < tripleta[0][1]){
                   for (int i = 1; i < tripleta.length; i++) {
                        if(Integer.parseInt(comp[0]) == tripleta[i][0] && Integer.parseInt(comp[1]) == tripleta[i][1]&& Integer.parseInt(comp[2]) == tripleta[i][2]){
                            bandera = true;
                            for(int j = i;j+1<tripleta.length;j++){
                            tripleta[j][0] = tripleta[j+1][0];
                            tripleta[j][1] = tripleta[j+1][1];
                            tripleta[j][2] = tripleta[j+1][2];
                            }
                            tripleta[0][2]--;
                            i = tripleta.length;
                        }
                   }
                }
                
                
                break;
            default:    System.out.println("Opcion incorrecta");
                break;
        }
        if (bandera) {
            System.out.println("El dato se a eliminado exitosamente");
        } else {
            System.out.println("El dato a eliminar no se encuentra en la tripleta");
        }
        Redimensionar();
    }

}
