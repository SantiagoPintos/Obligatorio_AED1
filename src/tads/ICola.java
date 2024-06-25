package tads;


public interface ICola<T> {
    public void encolar(T dato);
    public void desencolar() ;  
    public boolean esVacia(); 
    public boolean esllena();
    public int  cantElementos() ;  
    public Nodo<T> frente();  
    public void mostrarCola();
}
