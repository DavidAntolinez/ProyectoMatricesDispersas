public class Forma2 {
    private Nodo Punta;

    public Forma2(int[][] Matriz) {
        Punta = new Nodo(Matriz.length, Matriz[0].length, 0);
        Nodo p = Punta;
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                if (Matriz[i][j] != 0) {
                    Nodo x = new Nodo(i, j, Matriz[i][j]);
                    p.setLf(x);
                    p = p.getLf();
                }
            }
        }
        p.setLf(Punta);
        Nodo q = Punta;
        for (int i = 0; i < Matriz[0].length; i++) {
            p = Punta.getLf();
            while (p != Punta) {
                if (p.getC() == i) {
                    q.setLc(p);
                    q = q.getLc();
                }
                p = p.getLf();
            }
        }
        q.setLc(Punta);
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo punta) {
        Punta = punta;
    }

    public void Mostrar() {
        Nodo p = Punta;
        String cadena = "";
        do {
            cadena += "[" + p.getF() + "]" + "[" + p.getC() + "]" + "[" + p.getDato() + "]";
            if (p.getLf() != Punta) {
                cadena += "-->";
            }
            p = p.getLf();
        } while (p != Punta);
        System.out.println(cadena);
    }

    public void Multiplicar(Forma2 b) {
    }

    public void SumarF() {
    }

    public void SumarC() {
    }

    public void Insertar() {
    }

    public void Eliminar() {
    }

    public void Sumar(Forma2 b) {
    }
}
