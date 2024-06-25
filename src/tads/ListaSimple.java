package tads;

public class ListaSimple<T extends Comparable<T>> implements ILista<T> {

    private Nodo<T> inicio;

    public ListaSimple() {
        inicio = null;
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public void agregarInicio(T n) {
        Nodo<T> nuevo = new Nodo(n);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }

    @Override
    public void agregarFinal(T n) {
        if (esVacia()) {
            agregarInicio(n);
        } else {
            Nodo<T> aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(new Nodo(n));
        }
    }

    @Override
    public void borrarInicio() {
        if (!esVacia()) {

            Nodo<T> aBorrar = inicio;
            inicio = inicio.getSiguiente();
            aBorrar.setSiguiente(null);
        }
    }

    @Override
    public void borrarFin() {
        if (!esVacia()) {
            if (inicio.getSiguiente() == null) { //tiene un solo elemento
                borrarInicio();
            } else {
                Nodo<T> aux = inicio;
                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(null);
            }
        }
    }

    @Override
    public void vaciar() {
        inicio = null;
    }

    @Override
    public void mostrar() {
        Nodo aux = inicio;
        while (aux != null) {
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    @Override
    public boolean estaElemento(T n) {
        Nodo<T> aux = inicio;
        boolean existe = false;
        while (aux != null && !existe) {
            if (aux.getDato().equals(n)) {
                existe = true;
            }
            aux = aux.getSiguiente();
        }
        return existe;
    }

    @Override
    public int cantElementos() {
        int n = 0;
        if (!esVacia()) {
            Nodo aux = inicio;
            while (aux != null) {
                aux = aux.getSiguiente();
                n++;
            }
        }
        return n;
    }

    @Override
    public void borrarElemento(T n) {
        Nodo<T> aux = inicio;
        if (!esVacia()) {
            if (inicio.getDato().equals(n)) { // es el primero
                borrarInicio();
            } else {
                while (aux.getSiguiente() != null && !aux.getSiguiente().getDato().equals(n)) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() != null) {
                    Nodo aBorrar = aux.getSiguiente();
                    aux.setSiguiente(aBorrar.getSiguiente());
                    aBorrar.setSiguiente(null);
                }
            }

        }
    }

    @Override
    public void agregarOrd(T n) {
        Nodo<T> aux = inicio;

        if (esVacia() || inicio.getDato().compareTo(n) >= 0) { // Es el primero
            agregarInicio(n);
        } else {
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato().compareTo(n) < 0) {
                aux = aux.getSiguiente();
            }
            if (aux.getSiguiente() == null) { // Es el ultimo
                agregarFinal(n);
            } else {
                Nodo<T> nuevo = new Nodo(n);
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }
        }
    }

    @Override
    public Nodo<T> buscarElemento(T n) {
        Nodo<T> aux = inicio;
        Nodo<T> aRetornar = null;
        boolean existe = false;
        while (aux != null && existe == false) {
            if (aux.getDato().equals(n)) {
                aRetornar = aux;
                existe = true;
            }
            aux = aux.getSiguiente();
        }        
        return aRetornar;
    }

    @Override
    public Nodo getInicio() {
        return inicio;
    }

}
