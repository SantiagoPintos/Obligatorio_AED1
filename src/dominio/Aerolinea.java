package dominio;

import tads.ListaSimple;

public class Aerolinea implements Comparable<Aerolinea> {

    private String nombre;
    private String pais;
    private int cantMaxAviones;
    private ListaSimple<Avion> listaAviones;

    public Aerolinea(String nombre, String pais, int cantMaxAviones) {
        this.setNombre(nombre);
        this.setPais(pais);
        this.setCantMaxAviones(cantMaxAviones);
        this.listaAviones = new ListaSimple();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCantMaxAviones() {
        return cantMaxAviones;
    }

    public void setCantMaxAviones(int cantMaxAviones) {
        this.cantMaxAviones = cantMaxAviones;
    }

    public ListaSimple<Avion> getListaAviones() {
        return listaAviones;
    }

    public void setListaAviones(ListaSimple<Avion> listaAviones) {
        this.listaAviones = listaAviones;
    }

    @Override
    public boolean equals(Object c) {
        Aerolinea a = (Aerolinea)c;
        return this.getNombre().equalsIgnoreCase(a.getNombre());
    }
    
    @Override
    public int compareTo(Aerolinea a){
        return this.getNombre().compareTo(a.getNombre());
    }
    
    @Override
    public String toString(){
        return this.nombre + "-" + this.pais + "-" + this.cantMaxAviones + "|" ;
    }
    
    

}
