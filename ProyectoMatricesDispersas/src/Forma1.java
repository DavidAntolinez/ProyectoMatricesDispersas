import java.util.Scanner;

public class Forma1 {
    private Nodo Punta;

    public Forma1(int[][] matriz) {
        Punta = null;
        Paso1(matriz.length, matriz[0].length);
        Paso2(matriz);
        Paso3();
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo punta) {
        Punta = punta;
    }

    private void Paso1(int f, int c) {
        int mayor;
        if (f > c) {
            mayor = f;
        } else {
            mayor = c;
        }
        Nodo x = new Nodo(f, c, 0);
        Punta = x;
        Nodo p = Punta;
        for (int i = 0; i < mayor; i++) {
            x = new Nodo(i, i, 0);
            p.setLiga(x);
            p = x;
        }
        p.setLiga(Punta);
    }

    private void Paso2(int[][] M) {
        Nodo p = Punta.getLiga();
        Nodo q = p;
        Nodo x;
        for (int i = 0; i < M.length; i++) {
            q = p;
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] != 0) {
                    x = new Nodo(i, j, M[i][j]);
                    q.setLf(x);
                    q = q.getLf();
                }
            }
            q.setLf(p);
            p = p.getLiga();
        }
        p = Punta.getLiga();
        while (p != Punta) {
            if (p.getLc() == null) {
                p.setLc(p);
            }
            if (p.getLf() == null) {
                p.setLf(p);
            }
            p = p.getLiga();
        }
    }

    private void Paso3() {
        Nodo RC = Punta.getLiga(), a = RC, p = Punta.getLiga(), q = p.getLf();
        while (RC != Punta) {
            a = RC;
            p = Punta.getLiga();
            while (p != Punta) {
                q = p.getLf();
                while (q != p) {
                    if (q.getC() == RC.getC()) {
                        a.setLc(q);
                        a = a.getLc();
                    }
                    q = q.getLf();
                }
                p = p.getLiga();
            }
            a.setLc(RC);
            RC = RC.getLiga();
        }
    }

    public void Mostrar() {
        Nodo p = Punta.getLiga();
        System.out.println("[" + Punta.getF() + "]" + "[" + Punta.getC() + "]" + "[" + Punta.getDato() + "]");
        while (p != Punta) {
            Nodo q = p.getLf();
            String cadena;
            if (p.getLf() == p) {
                cadena = "[" + p.getF() + "]" + "[" + p.getC() + "]" + "[" + p.getDato() + "]";
            } else {
                cadena = "[" + p.getF() + "]" + "[" + p.getC() + "]" + "[" + p.getDato() + "]-->";
            }
            while (q != p) {
                if (q.getLf() == p) {
                    cadena += "[" + q.getF() + "]" + "[" + q.getC() + "]" + "[" + q.getDato() + "]";
                } else {
                    cadena += "[" + q.getF() + "]" + "[" + q.getC() + "]" + "[" + q.getDato() + "]-->";
                }
                q = q.getLf();
            }
            p = p.getLiga();
            System.out.println(cadena);
        }
    }

    public void Eliminar() {
        boolean bandera;
        int opc;
        do {
            System.out.println(
                    "ingrese 1, 2 o 3 si quieres eliminar por dato, posicion o posicion y dato respectivamente");
            Scanner Basura = new Scanner(System.in);
            opc = Basura.nextInt();
            bandera = false;
            Nodo p = Punta.getLiga(), q = p.getLf(), o = p.getLf(), w = p.getLc();
            switch (opc) {
                case 1:
                    System.out.println("ingrese el dato a eliminar");
                    int dato = Basura.nextInt();
                    while (p != Punta) {
                        q = p.getLf();
                        o = p;
                        while (q != p) {
                            if (q.getDato() == dato) {
                                bandera = true;
                                w = q.getLc();
                                while (w.getLc() != q) {
                                    w = w.getLc();
                                }
                                o.setLf(q.getLf());
                                w.setLc(q.getLc());
                            }
                            q = q.getLf();
                            o = o.getLf();
                        }
                        p = p.getLiga();
                    }
                    break;
                case 2:
                    System.out.println(
                            "ingrese primero las filas, y luego las columnas, ejemplo: (1,2) uno es las filas y dos las columnas");
                    String cadena = Basura.next();
                    String[] componentes = cadena.split(",");
                    while (p != Punta) {
                        q = p.getLf();
                        o = p;
                        while (q != p) {
                            if (q.getF() == Integer.parseInt(componentes[0])
                                    && q.getC() == Integer.parseInt(componentes[1])) {
                                bandera = true;
                                w = q.getLc();
                                while (w.getLc() != q) {
                                    w = w.getLc();
                                }
                                o.setLf(q.getLf());
                                w.setLc(q.getLc());
                            }
                            q = q.getLf();
                            o = o.getLf();
                        }
                        p = p.getLiga();
                    }
                    break;
                case 3:
                    System.out.println(
                            "ingrese primero las filas, luego las columnas, y por ultimo el dato, ejemplo: (1,2,3) uno es las filas, dos las columnas y 3 el dato");
                    cadena = Basura.next();
                    String[] comp = cadena.split(",");
                    while (p != Punta) {
                        q = p.getLf();
                        o = p;
                        while (q != p) {
                            if (q.getF() == Integer.parseInt(comp[0]) && q.getC() == Integer.parseInt(comp[1])
                                    && q.getDato() == Integer.parseInt(comp[2])) {
                                bandera = true;
                                w = q.getLc();
                                while (w.getLc() != q) {
                                    w = w.getLc();
                                }
                                o.setLf(q.getLf());
                                w.setLc(q.getLc());
                            }
                            q = q.getLf();
                            o = o.getLf();
                        }
                        p = p.getLiga();
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opc != 1 && opc != 2 && opc != 3);
        if (bandera) {
            System.out.println("El dato se a eliminado exitosamente");
        } else {
            System.out.println("El dato a eliminar no se encuentra en la tripleta");
        }
    }

    public void Insertar() {
        System.out.println(
                "ingrese primero las filas, luego las columnas, y por ultimo el dato, ejemplo: (1,2,3) uno es las filas, dos las columnas y 3 el dato");
        Scanner Basura = new Scanner(System.in);
        String cadena = Basura.next();
        String[] comp = cadena.split(",");
        int dato = Integer.parseInt(comp[2]);
        int c = Integer.parseInt(comp[1]);
        int f = Integer.parseInt(comp[0]);
        boolean bandera = false;
        Nodo p = Punta.getLiga();
        while (p != Punta && !bandera) {
            Nodo q = p.getLf();
            while (q != p && !bandera) {
                if (q.getF() == f && q.getC() == c) {
                    bandera = true;
                    System.out.println(
                            "Se encontro un valor en esa posicion, ingrese 1 para reemplazarlo, o 2 para sumarlos");
                    int valor;
                    do {
                        valor = Basura.nextInt();
                        switch (valor) {
                            case 1:
                                q.setDato(dato);
                                break;
                            case 2:
                                q.setDato(q.getDato() + dato);
                                break;
                            default:
                                System.out.println("No seas idiota, coloca un 1 o 2, usuario de mierda");
                                break;
                        }
                    } while (valor != 1 && valor != 2);
                }
                q = q.getLf();
            }
            p = p.getLiga();
        }

    }

    public void Multiplicar(Forma1 b){}

    public void SumarF(){}

    public void SumarC(){}

    public void Sumar(Forma1 b){}

}
