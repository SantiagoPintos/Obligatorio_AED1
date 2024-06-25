
package dominio;


public class Pasaje implements Comparable<Pasaje> {
    
    private Cliente cliente;
    private Vuelo vuelo;
    private int categoriaPasaje;
    private String estado;
    
    
    public Pasaje(Cliente cliente, Vuelo vuelo, int categoriaPasaje, String estado){
        this.setPasaporteCliente(cliente);
        this.setCodigoVuelo(vuelo);
        this.setCategoriaPasaje(categoriaPasaje);           
        this.setEstado(estado);
    }

    /**
     * @return the pasaporteCliente
     */
    public Cliente getPasaporteCliente() {
        return cliente;
    }

    /**
     * @param pasaporteCliente the pasaporteCliente to set
     */
    public void setPasaporteCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the codigoVuelo
     */
    public Vuelo getCodigoVuelo() {
        return vuelo;
    }

    /**
     * @param codigoVuelo the codigoVuelo to set
     */
    public void setCodigoVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
/**
     * @return the codigoVuelo
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the codigoVuelo to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    /**
     * @return the categoriaPasaje
     */
    public int getCategoriaPasaje() {
        return categoriaPasaje;
    }

    /**
     * @param categoriaPasaje the categoriaPasaje to set
     */
    public void setCategoriaPasaje(int categoriaPasaje) {
        this.categoriaPasaje = categoriaPasaje;
    }
    
    
    @Override
    public boolean equals(Object o){
        Pasaje p = (Pasaje)o;
        return this.getPasaporteCliente().getPasaporte().equalsIgnoreCase(p.getPasaporteCliente().getPasaporte()) && this.getCodigoVuelo().equals(p.getCodigoVuelo());
    }
    
    
    @Override
    public int compareTo(Pasaje p){       
        return this.getPasaporteCliente().compareTo(p.getPasaporteCliente());
        
    }
    @Override
    public String toString(){
        return this.getCodigoVuelo().getCodigoVuelo();
    }
       
}
