package desempenio1;

import clase5ListaGenericaDobleEnlace.ListaGenDobleEnlace;
import clase6ProblemaAplicacionPila.AplicacionPila;

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
                insertarAlFinal(intA);
                insertarAlFinal(intB);
            }
        } catch (NumberFormatException e) {
            System.out.println("valor/es incorrectos");
        }
    }

    public void elimnarPrimeroYUltimo() {
        eliminarUltimo();
        eliminarPrimero();
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

    public void eliminarUltimo() {
        Nodo reco;
        reco = raiz;
        for (int f = 1; f <= cantidad() - 2; f++)
            reco = reco.sig;
        Nodo prox = reco.sig;
        prox = prox.sig;
        reco.sig = prox;
        if (prox != null)
            prox.ant = reco;

    }

    public void insertarAlPrincipio(int x) {

        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = x;
        if (raiz == null) {
            nuevo.sig = null;
            raiz = nuevo;
        } else {
            nuevo.sig = raiz;
            raiz = nuevo;
        }
    }

    public void eliminarPrimero() {
        raiz = raiz.sig;
        if (raiz != null)
            raiz.ant = null;
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
            lista += (" "+reco.info + " ");
            reco = reco.sig;
        }
        System.out.println();
        return lista;
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
