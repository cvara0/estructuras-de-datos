package desempenio1;

public class Lista {
    private Nodo raiz;

    public Lista() {
        this.raiz = null;
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
            eliminarPrimeroIngresado();
            eliminarUltimoIngresado();
        } catch (NullPointerException e) {
            System.out.println("Lista vacia");
        }
    }

    public void cambiarPrimeroConUltimo() {
        try {
            int ultimo = extraerUltimo();
            int primero = extraerPrimero();
            elimnarPrimeroYUltimo();
            insertarAlPrincipio(ultimo);
            insertarAlFinal(primero);
        } catch (NullPointerException e) {
            System.out.println("Lista vacia");
        }
    }

    //primero de la lista
    public void eliminarIgualesAInfoPrimero() {
        Nodo reco;
        reco = raiz;
        int pos = 2;
        try {
            int primero = extraerPrimero();
            while (reco.sig != null) {
                reco = reco.sig;
                if (reco.info == primero) {
                    borrar(pos);
                    pos--;
                }
                pos++;
            }
        } catch (NullPointerException e) {
            System.out.println("Lista vacia");
        }
    }

//final de la lista
    public void insertarAlFinal(int x) {
        Nodo nuevo = new Nodo();
        try {
            nuevo.info = x;
            Nodo reco = raiz;
            while (reco.sig != null) {
                reco = reco.sig;
            }
            reco.sig = nuevo;
            nuevo.ant = reco;
            nuevo.sig = null;
        } catch (NumberFormatException e) {
            System.out.println("Valor incorrecto");
        } catch (NullPointerException e) {
            System.out.println("Campo vacio");
        }
    }

    //primero ingresado
    public void eliminarPrimeroIngresado() {
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

    //ultimo en la lista
    public int extraerUltimo() {
        Nodo reco;
        reco = raiz;
        try {
            while (reco.sig != null)
                reco = reco.sig;
        } catch (NullPointerException e) {
            System.out.println("Lista vacia");
        }
        return reco.info;
    }

    //principio de la lista
    public void insertarAlPrincipio(int x) {

        Nodo nuevo;
        nuevo = new Nodo();

        try {
            nuevo.info = x;
            if (raiz == null) {
                nuevo.sig = null;
            } else {
                nuevo.sig = raiz;
            }
            raiz = nuevo;
        } catch (NumberFormatException e) {
            System.out.println("Valor incorrecto");
        } catch (NullPointerException e) {
            System.out.println("Campo vacio");
        }
    }

    //ultimo ingresado
    public void eliminarUltimoIngresado() {
        raiz = raiz.sig;
        try {
            if (raiz != null)
                raiz.ant = null;
        } catch (NullPointerException e) {
            System.out.println("Lista vacia");
        }
    }

    //primero de la lista
    public int extraerPrimero() {
        return raiz.info;
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
        return "La suma de [ " + info + " ] es " + sum;
    }

}
