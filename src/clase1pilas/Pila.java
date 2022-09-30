package clase1pilas;

public class Pila {
    /////
    class Nodo {
        int info;
        Nodo sig;
    }

    private Nodo raiz;//puntero raiz

    ////////
//  si raiz es null la lista esta vacia, caso contrario tiene la direccion
// del primer nodo de la lista
    Pila() {
        this.raiz = null;
    }

    public void insertar(int x) {
        Nodo nuevo = new Nodo();//este se elimina solo despues recordar
        nuevo.info = x;
        /*Si la lista está vacía (es decir el puntero externo raiz tiene almacenado el null)
            debemos guardar en el campo sig del nodo el valor null para indicar que no hay otro nodo
              después de este, y hacer que raiz apunte al nodo creado.*/
        nuevo.sig = raiz == null ? null : this.raiz;
        this.raiz = nuevo;
        /*if (raiz == null) {
            nuevo.sig = null;
            raiz = nuevo;
        } else {
            nuevo.sig = raiz;
            raiz = nuevo;
        }*/
    }

    public int extraer() {
        if (raiz != null) {
            int informacion = raiz.info;
            raiz = raiz.sig;//el nodo del cual se extrae la informacion es eliminado
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public int retornar() {
        if (this.raiz != null) {
            int informacion = this.raiz.info;
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void imprimir() {
        Nodo reco = this.raiz;
        System.out.println("Listado de todos los elementos de la pila.");
        while (reco != null) {
            System.out.print(reco.info + "-");
            reco = reco.sig;
        }
        System.out.println();
    }

    /////////////////////////////////
    //1 – Implementar un método en la clase Pila que retorne la cantidad de nodos que contiene.
    public int cantidad() {
        Nodo reco = this.raiz;
        int cantidad = 0;
        while (reco != null) {
            cantidad++;
            reco = reco.sig;
        }
        return cantidad;
    }

    //2 – Implementar un método que fije en cero todos los elementos de información de una lista
    //tipo pila.
    public void inicializarEnCero() {
        Nodo reco = this.raiz;
        while (reco!=null){
            reco.info=0;
            reco=reco.sig;
        }
    }

    //3 – Desarrollar un método que retorne la información del último nodo de la pila (no se debe
    //borrar el nodo).
    public int retornarUltimo() {
        Nodo reco = this.raiz;
        Nodo aux=new Nodo();
        while (reco!=null){
            aux=reco;
            reco=reco.sig;
            if (reco==null)
                break;
        }
        return aux.info;
    }

    /////////////////////////////////

    public static void main(String[] ar) {
        Pila pila1 = new Pila();
        pila1.insertar(10);
        pila1.insertar(40);
        pila1.insertar(3);
        pila1.insertar(2);
        pila1.imprimir();
        System.out.println("Cantidad de elementos: " + pila1.cantidad());
        System.out.println("Ultimo elemento: " + pila1.retornarUltimo());
        //System.out.println("Extraemos de la pila:" + pila1.extraer());
        //pila1.imprimir();
        //System.out.println("Retornamos primero de la pila:" + pila1.retornar());
        //pila1.imprimir();
        pila1.inicializarEnCero();
        pila1.imprimir();
    }

}
