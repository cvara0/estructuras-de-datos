package clase4ListaGenericaOrdenada;

public class ListaGenericaOrdenada {
    class Nodo {
        int info;
        Nodo sig;
    }

    private Nodo raiz;

    public ListaGenericaOrdenada() {
        raiz = null;
    }

    void insertar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        if (raiz == null) {
            raiz = nuevo;
        } else {
            if (x < raiz.info) {
                nuevo.sig = raiz;
                raiz = nuevo;
            } else {
                Nodo reco = raiz;
                Nodo atras = raiz;
                while (x >= reco.info && reco.sig != null) {
                    atras = reco;
                    reco = reco.sig;
                }
                if (x >= reco.info) {
                    reco.sig = nuevo;
                } else {
                    nuevo.sig = reco;
                    atras.sig = nuevo;
                }
            }
        }
    }

    public void imprimir() {
        Nodo reco = raiz;
        while (reco != null) {
            System.out.print(reco.info + "-");
            reco = reco.sig;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaGenericaOrdenada lo = new ListaGenericaOrdenada();
        lo.insertar(10);
        lo.insertar(5);
        lo.insertar(7);
        lo.insertar(50);
        lo.imprimir();
    }

}
