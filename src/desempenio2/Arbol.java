package desempenio2;

import clase10ArbolBinario.ArbolBinario2;

import java.util.ArrayList;
import java.util.List;

public class Arbol {

    int cant, altura;
    int cont=0;
    Nodo raiz;
    String preList = "";

    public String getPreList() {
        return preList;
    }

    public void setPreList(String preList) {
        this.preList = preList;
    }

    public void insertarNodo(String infoString) {
        try {
            this.preList="";
            int info = Integer.parseInt(infoString);
            Nodo nuevo;
            nuevo = new Nodo();
            nuevo.info = info;
            nuevo.izq = null;
            nuevo.der = null;
            if (raiz == null)
                raiz = nuevo;
            else {
                Nodo anterior = null;
                Nodo reco = raiz;
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
        } catch (NumberFormatException e) {
            System.out.println("valor incorrecto");
        }
    }

    /////////////////////////////////////////////////////////////////
    private void imprimirPre(Nodo reco) {
        if (reco != null) {
            System.out.print(reco.info+ " ");
           this.preList += reco.info+" ";
            imprimirPre(reco.izq);
            imprimirPre(reco.der);
        }

    }
    public void imprimirPre() {
        imprimirPre(raiz);
    }

    /////////////////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////////////////

    public void limpiar() {
        raiz = null;
    }
}
