package desempenio1;

import clase5ListaGenericaDobleEnlace.ListaGenDobleEnlace;
import clase6ProblemaAplicacionPila.AplicacionPila;
import sun.util.locale.provider.JRELocaleConstants;

public class Lista {
    private Nodo raiz;

    String mensajeErr;

    public Lista() {
        this.raiz = null;
        this.mensajeErr = "";
    }

    public void insertarPar(String a, String b) {

        try {
            if (cantidad() != 4) {
                int intA = Integer.parseInt(a);
                int intB = Integer.parseInt(b);
                insertarAlPrincipio(intA);
                insertarAlPrincipio(intB);
            } else {
                int intA = Integer.parseInt(a);
                int intB = Integer.parseInt(b);
                insertarAlFinal(intB);
                insertarAlFinal(intA);
            }
        } catch (NumberFormatException e) {
            System.out.println("valor/es incorrectos");
        }
    }

    public void elimnarPrimeroYUltimo() {
        try {
            eliminarPrimero();
            eliminarUltimo();
        } catch (NullPointerException e) {
            System.out.println("Lista vacia");
        }
    }

    public void cambiarPrimeroConUltimo() {
        int ultimo = extraerUltimo();
        int primero = extraerPrimero();
        elimnarPrimeroYUltimo();
        insertarAlPrincipio(ultimo);
        insertarAlFinal(primero);
    }

    public void eliminarIgualesAInfoPrimero() {
        Nodo reco;
        reco = raiz;
        int pos=2;
        int primero = extraerPrimero();
        try {
            while (reco.sig != null) {
                reco = reco.sig;


                if (reco.info == primero) {
                    //System.out.println(pos);
                    borrar(pos);

                    pos--;
                }
                pos++;

            }

        } catch (NullPointerException e) {
            System.out.println("Lista vacia");
        }
    }


    public void insertarAlFinal(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        Nodo reco = raiz;
        while (reco.sig != null) {
            reco = reco.sig;
        }
        reco.sig = nuevo;
        nuevo.ant = reco;
        nuevo.sig = null;
    }

    public void eliminarPrimero() {
        Nodo reco;
        reco = raiz;
        try {
            for (int f = 1; f <= cantidad() - 2; f++)
                reco = reco.sig;
            Nodo prox = reco.sig;
            prox = prox.sig;
            reco.sig = prox;
            if (prox != null)
                prox.ant = reco;
        } catch (NullPointerException e) {
            System.out.println("Lista vacia");
        }
    }

    public int extraerUltimo() {
        Nodo reco;
        reco = raiz;
        while (reco.sig != null)
            reco = reco.sig;
        return reco.info;
    }

    public void insertarAlPrincipio(int x) {

        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = x;
        if (raiz == null) {
            nuevo.sig = null;
        } else {
            nuevo.sig = raiz;
        }
        raiz = nuevo;
    }

    public void eliminarUltimo() {
        raiz = raiz.sig;
        try {
            if (raiz != null)
                raiz.ant = null;
        } catch (NullPointerException e) {
            System.out.println("Lista vacia");
        }

    }

    public int extraerPrimero() {
        Nodo reco;
        reco = raiz;
        return reco.info;
    }

    public int cantidad() {
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }

    public String imprimir() {
        Nodo reco = raiz;
        String lista = "";
        while (reco != null) {
            lista += (" " + reco.info + " ");
            reco = reco.sig;
        }
        System.out.println();
        return lista;
    }

    public void borrar(int pos) {
        if (pos <= cantidad()) {
            if (pos == 1) {
                raiz = raiz.sig;
                if (raiz != null)
                    raiz.ant = null;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1; f <= pos - 2; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                prox = prox.sig;
                reco.sig = prox;
                if (prox != null)
                    prox.ant = reco;
            }
        }
    }

    public void limpiar() {

        raiz = null;
    }

    public String sumarNodosPosImpar() {
        Nodo reco = raiz;
        int i = 0;
        int sum = 0;
        String info = "";
        while (reco != null) {
            if (i % 2 == 0) {
                sum += reco.info;
                info += " " + reco.info + " ";
            }
            i++;
            reco = reco.sig;
        }
        return "La suma de [" + info + "] es " + sum;
    }

}
