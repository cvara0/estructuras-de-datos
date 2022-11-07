package desempenio2;

public class Arbol {

    int cantHojaIzq;
    Nodo raiz;
    String preList = "";
    String entreList = "";
    String postList = "";
    String ingresoString = "";

    public String getPreList() {
        return preList;
    }

    public String getIngresoString() {
        return ingresoString;
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
            if (raiz == null) {
                raiz = nuevo;
                this.ingresoString = "Nodo raiz: " + raiz.info;
            } else {
                Nodo anterior = null;
                Nodo reco = raiz;
                while (reco != null) {
                    anterior = reco;
                    if (info < reco.info) {
                        this.ingresoString = info + " - por izquierda del nodo " + reco.info;
                        reco = reco.izq;
                    } else {
                        this.ingresoString = info + " - por derecha del nodo " + reco.info;
                        reco = reco.der;
                    }
                }
                if (info < anterior.info)
                    anterior.izq = nuevo;
                else
                    anterior.der = nuevo;
            }
        } catch (NumberFormatException e) {
            this.ingresoString = "Ingreso incorrecto ( 1 )";
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
        this.preList = "";
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
        this.entreList = "";
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
        this.postList = "";
        imprimirPost(raiz);
    }


    public void limpiar() {
        raiz = null;
    }
    /////////////////////////////////////////////////////////////////

    public String getRaiz() {
        if (raiz != null)
            return String.valueOf(raiz.info);
        return "--";
    }

    public String hallarMenorDeSubArbolIzq() {
        if (raiz != null && raiz.izq != null) {
            Nodo reco = raiz;
            while (reco.izq != null)
                reco = reco.izq;
            return String.valueOf(reco.info);
        }
        return "--";
    }

    public String hallarMayorDeSubArbolIzq() {
        if (raiz != null && raiz.izq != null) {
            Nodo reco = raiz;
            reco = reco.izq;
            while (reco.der != null)
                reco = reco.der;
            return String.valueOf(reco.info);
        }
        return "--";
    }

    private void cantidadNodosHojaDeSubArbolIzq(Nodo reco) {
        if (reco != null) {
            if (reco.izq == null && reco.der == null)
                this.cantHojaIzq++;
            cantidadNodosHojaDeSubArbolIzq(reco.izq);
            cantidadNodosHojaDeSubArbolIzq(reco.der);
        }
    }

    public String cantidadNodosHojaDeSubArbolIzq() {
        this.cantHojaIzq = 0;
        if (raiz != null) {
            cantidadNodosHojaDeSubArbolIzq(raiz.izq);
            return String.valueOf(this.cantHojaIzq);
        }
        return "--";
    }

    public void borrarMayorSubIzq() {
        if (raiz != null && raiz.izq != null) {
            Nodo reco = raiz.izq;
            Nodo anterior = reco;
            while (reco.der != null) {
                anterior = reco;
                reco = reco.der;
            }
            if (reco == raiz.izq)
                this.ingresoString = "Nada que eliminar";
            else {
                this.ingresoString = "Eliminado nodo " + reco.info;
                anterior.der = null;
            }
        } else {
            this.ingresoString = "Nada que eliminar";
        }
    }

    public Boolean existeEnPrimeros3Niveles(String infoString) {
        try {
            int info = Integer.parseInt(infoString);
            int nivel = 0;
            Nodo reco = raiz;
            while (reco != null) {
                if (info == reco.info){
                    this.ingresoString = info+" si esta en los primeros 3 niveles";
                    return true;
                }
                else if (info > reco.info) {
                    nivel++;
                    reco = reco.der;
                } else {
                    nivel++;
                    reco = reco.izq;
                }
                if (nivel > 3){
                    this.ingresoString = info+" no esta en los primeros 3 niveles";
                    return false;
                }
            }
            this.ingresoString = infoString+" no esta en los primeros 3 niveles";
            return false;
        } catch (NumberFormatException e) {
            this.ingresoString = "Ingreso incorrecto ( 3 )";
        }
        return false;
    }
}
