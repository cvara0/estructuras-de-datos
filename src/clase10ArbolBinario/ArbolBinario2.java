package clase10ArbolBinario;

public class ArbolBinario2 {

    class Nodo {
        int info;
        Nodo izq, der;
    }

    int cant, altura;
    Nodo raiz;

    public void insertar(int info) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = info;
        nuevo.izq = null;
        nuevo.der = null;
        if (raiz == null)
            raiz = nuevo;
        else {
            Nodo anterior = null, reco;
            reco = raiz;
            while (reco != null) {
                anterior = reco;
                if (info < reco.info)
                    reco = reco.izq;
                else
                    reco = reco.der;
            }
            if (info < anterior.info)
                anterior.izq = nuevo;
            else
                anterior.der = nuevo;
        }
    }

    private void imprimirPre(Nodo reco) {
        if (reco != null) {
            System.out.print(reco.info + " ");
            imprimirPre(reco.izq);
            imprimirPre(reco.der);
        }
    }

    public void imprimirPre() {
        imprimirPre(raiz);
        System.out.println();
    }

    private void imprimirEntre(Nodo reco) {
        if (reco != null) {
            imprimirEntre(reco.izq);
            System.out.print(reco.info + " ");
            imprimirEntre(reco.der);
        }
    }

    public void imprimirEntre() {
        imprimirEntre(raiz);
        System.out.println();
    }

    private void imprimirPost(Nodo reco) {
        if (reco != null) {
            imprimirPost(reco.izq);
            imprimirPost(reco.der);
            System.out.print(reco.info + " ");
        }
    }

    public void imprimirPost() {
        imprimirPost(raiz);
        System.out.println();
    }

    public boolean existe(int info) {
        Nodo reco = raiz;
        while (reco != null) {
            if (info == reco.info)
                return true;
            else if (info > reco.info)
                reco = reco.der;
            else
                reco = reco.izq;
        }
        return false;
    }

    private void cantidad(Nodo reco) {
        if (reco != null) {
            cant++;
            cantidad(reco.izq);
            cantidad(reco.der);
        }
    }

    public int cantidad() {
        cant = 0;
        cantidad(raiz);
        return cant;
    }

    private void cantidadNodosHoja(Nodo reco) {
        if (reco != null) {
            if (reco.izq == null && reco.der == null)
                cant++;
            cantidadNodosHoja(reco.izq);
            cantidadNodosHoja(reco.der);
        }
    }

    public int cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(raiz);
        return cant;
    }

    private void imprimirEntreConNivel(Nodo reco, int nivel) {
        if (reco != null) {
            imprimirEntreConNivel(reco.izq, nivel + 1);
            System.out.print(reco.info + " (" + nivel + ") - ");
            imprimirEntreConNivel(reco.der, nivel + 1);
        }
    }

    public void imprimirEntreConNivel() {
        imprimirEntreConNivel(raiz, 1);
        System.out.println();
    }

    private void retornarAltura(Nodo reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.izq, nivel + 1);
            if (nivel > altura)
                altura = nivel;
            retornarAltura(reco.der, nivel + 1);
        }
    }

    public int retornarAltura() {
        altura = 0;
        retornarAltura(raiz, 1);
        return altura;
    }

    public void mayorValorl() {
        if (raiz != null) {
            Nodo reco = raiz;
            while (reco.der != null)
                reco = reco.der;
            System.out.println("Mayor valor del �rbol:" + reco.info);
        }
    }

    public void menorValor() {
        if (raiz != null) {
            Nodo reco = raiz;
            while (reco.izq != null)
                reco = reco.izq;
            System.out.println("Menor valor del �rbol:" + reco.info);
        }
    }

    public void borrarMenor() {
        if (raiz != null) {
            if (raiz.izq == null)
                raiz = raiz.der;
            else {
                Nodo atras = raiz;
                Nodo reco = raiz.izq;
                while (reco.izq != null) {
                    atras = reco;
                    reco = reco.izq;
                }
                atras.izq = reco.der;
            }
        }
    }

    public static void main(String[] ar) {
        ArbolBinario2 abo = new ArbolBinario2();
        abo.insertar(400); // raiz
        abo.insertar(100);
        abo.insertar(700);
        abo.insertar(200);
        abo.insertar(50);
        abo.insertar(1200);
        abo.insertar(15);
        abo.insertar(75);
        abo.insertar(300);

        System.out.println("Impresion preorden: ");
        abo.imprimirPre();
        System.out.println("Impresion entreorden: ");
        abo.imprimirEntre();
        System.out.println("Impresion postorden: ");
        abo.imprimirPost();

        if (abo.existe(50))
            System.out.println("Existe valor 50 en el �rbol");
        else
            System.out.println("no existe el valor 50 en el �rbol");
        if (abo.existe(350))
            System.out.println("Existe valor 350 en el �rbol");
        else
            System.out.println("No existe el valor 350 en el �rbol");

        System.out.println("Cantidad de nodos del �rbol:" + abo.cantidad());

        System.out.println("Cantidad de nodos HOJA del �rbol:" + abo.cantidadNodosHoja());

        System.out.println("Impresion en entre orden junto al nivel del nodo.");
        abo.imprimirEntreConNivel();

        System.out.print("Artura del arbol:");
        System.out.println(abo.retornarAltura());

        System.out.println("Mayor y menor del arbol:");
        abo.mayorValorl();
        abo.menorValor();

        abo.borrarMenor();
        System.out.println("Impresion entreorden luego de borrar el menor ");
        abo.imprimirEntre();

    }
}
