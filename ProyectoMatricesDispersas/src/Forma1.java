public class Forma1 {
    private Nodo Punta;

    public Forma1(int[][] matriz) {
        Punta = null;
        Paso1(matriz.length,matriz[0].length);
        Paso2(matriz);
        Paso3();
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo punta) {
        Punta = punta;
    }

    private void Paso1(int f, int c){
        int mayor;
        if(f > c){
            mayor = f;
        }else{
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

    private void Paso2(int[][] M){
        Nodo p = Punta.getLiga();
        Nodo q = p;
        Nodo x;
        for (int i = 0; i < M.length; i++) {
            q = p;
            for (int j = 0; j < M[i].length; j++) {
                if(M[i][j] != 0){
                    x = new Nodo(i, j, M[i][j]);
                    q.setLf(x);
                    q = q.getLf();
                }
            }
            q.setLf(p);
            p = p.getLiga();
        }
    }

    private void Paso3(){
        Nodo RC = Punta.getLiga(),a = RC, p = Punta.getLiga(), q = p.getLf();
        while(RC != Punta){
            a = RC;
            p = Punta.getLiga();
            while(p != Punta){
                q = p.getLf();
                while(q != p){
                    if(q.getC() == RC.getC()){
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

    public void Mostrar(){

    }
    
}
