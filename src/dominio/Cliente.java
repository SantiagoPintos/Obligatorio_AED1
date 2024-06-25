package dominio;

import tads.ListaSimple;

public class Cliente implements Comparable<Cliente>{

    private String pasaporte;
    private String nombre;
    private int edad;
    private ListaSimple<Pasaje> listaPasajes;

    public Cliente(String pasaporte, String nombre, int edad) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * @return the pasaporte
     */
    public String getPasaporte() {
        return pasaporte;
    }

    /**
     * @param pasaporte the pasaporte to set
     */
    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the listaPasajes
     */
    public ListaSimple<Pasaje> getListaPasajes() {
        return listaPasajes;
    }

    /**
     * @param listaPasajes the listaPasajes to set
     */
    public void setListaPasajes(ListaSimple<Pasaje> listaPasajes) {
        this.listaPasajes = listaPasajes;
    }
    
    
    @Override
    public boolean equals(Object d) {
        Cliente c = (Cliente)d;
        return this.getPasaporte().equalsIgnoreCase(c.getPasaporte());
    }
    
    @Override
    public int compareTo(Cliente c){
        return this.getPasaporte().compareTo(c.getPasaporte());
    }
    

}
