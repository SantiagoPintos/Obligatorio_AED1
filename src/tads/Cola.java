package tads;

public class Cola <T extends Comparable<T>> implements ICola<T>{
    private Nodo inicio;
    private Nodo fin;
    int cantElementos;
    int cantMax;

    public Cola(int cantMaxima) {
        cantMax = cantMaxima;
        inicio = null;
        fin = null;
    }

    @Override
    public void encolar(T dato) {

        if (!this.esllena()) {

            Nodo nuevo = new Nodo(dato);

            if (this.esVacia()) {
                fin = nuevo;
            }

            nuevo.setSiguiente(getInicio());
            inicio = nuevo;
            cantElementos++;
        }
        else{
            System.out.println("La cola esta llena");
        }
    }

    @Override
    public void desencolar() {

        if (!this.esVacia()) {

            if (cantElementos == 1) {
                inicio = null; //To change body of generated methods, choose Tools | Templates.
                fin = null;
                cantElementos = 0;
            } else {

                Nodo actual = getInicio();

                while (actual.getSiguiente() != fin) {
                    actual = actual.getSiguiente();
                }

                actual.setSiguiente(null);
                fin = actual;

                cantElementos--;
            }
        }
    }

    @Override
    public boolean esVacia() {
        return getInicio() == null;
    }

    @Override
    public boolean esllena() {
        return cantElementos == cantMax;
    }

    @Override
    public int cantElementos() {
        return cantElementos;
    }

    @Override
    public Nodo frente() {
        Nodo ret = null;
        if (!this.esVacia()) {
            ret = fin;
        }        
        return ret;
    }

    public Nodo getInicio() {
        return inicio;
    }

    @Override
    public void mostrarCola() {

        Nodo mostrar = getInicio();

        while (mostrar != null) {

            System.out.print(mostrar.getDato() + " - ");
            mostrar = mostrar.getSiguiente();
        }

        System.out.println("");

    }
}
