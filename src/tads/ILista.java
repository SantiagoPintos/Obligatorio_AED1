
package tads;

public interface ILista<T> {
    public boolean esVacia();
    public void agregarInicio(T n);
    public void agregarFinal(T n);
    public void borrarInicio();
    public void borrarFin();
    public void vaciar();
    public void mostrar();
    public boolean estaElemento(T n);
    public int cantElementos();
    public void borrarElemento(T n);
    public void agregarOrd(T n);
    public Nodo<T> buscarElemento(T n);
    public Nodo getInicio();
}
