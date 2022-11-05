package desempenio2;

import clase10ArbolBinario.ArbolBinario2;

import java.util.ArrayList;
import java.util.List;

public class Arbol {

    int cant, altura;
    int cont = 0;
    Nodo raiz;
    String preList = "";
    String entreList = "";
    String postList = "";

    String ingresosList = "";
    String mayorDeSubArbolIzq = "";
    String menorDeSubArbolIzq = "";
    String existeEnPrimeros3Niveles = "No";
    String cantidadHojasDeSubArbolIzq = "";

    public String getPreList() {
        return preList;
    }

    public void setPreList(String preList) {
        this.preList = preList;
    }

    public String getEntreList() {
        return entreList;
    }

    public void setEntreList(String entreList) {
        this.entreList = entreList;
    }

    public String getPostList() {
        return postList;
    }

    public void setPostList(String postList) {
        this.postList = postList;
    }

//////////////////////////insertar nodo///////////////////////////////////////
    public void insertarNodo(String infoString) {
        try {
            this.preList = "";
            this.entreList = "";
            this.postList = "";
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

    //////////////////////////imprimir pre///////////////////////////////////////
    private void imprimirPre(Nodo reco) {
        if (reco != null) {
            this.preList += " " + reco.info + " ";
            imprimirPre(reco.izq);
            imprimirPre(reco.der);
        }
    }

    public void imprimirPre() {
        imprimirPre(raiz);
    }

    ////////////////////////////imprimir entre/////////////////////////////////////
    private void imprimirEntre(Nodo reco) {
        if (reco != null) {
            imprimirEntre(reco.izq);
            this.entreList += " " + reco.info + " ";
            imprimirEntre(reco.der);
        }
    }

    public void imprimirEntre() {
        imprimirEntre(raiz);
    }

    /////////////////////////////imprimir post////////////////////////////////////
    private void imprimirPost(Nodo reco) {
        if (reco != null) {
            imprimirPost(reco.izq);
            imprimirPost(reco.der);
            this.postList += " " + reco.info + " ";
        }
    }

    public void imprimirPost() {
        imprimirPost(raiz);
    }


    /////////////////////////////////////////////////////////////////

    public void limpiar() {
        raiz = null;
    }

    /////////////////////////////////////////////////////////////////
    public void borrarMayorSubIzq(){}
}
