
package dominio;


public class Pasaje implements Comparable<Pasaje> {
    
    private String pasaporteCliente;
    private String codigoVuelo;
    private int categoriaPasaje;
    
    public Pasaje(String pasaporteCliente, String codigoVuelo, int categoriaPasaje){
        this.pasaporteCliente = pasaporteCliente;
        this.codigoVuelo = codigoVuelo;
        this.categoriaPasaje = categoriaPasaje;           
    }

    /**
     * @return the pasaporteCliente
     */
    public String getPasaporteCliente() {
        return pasaporteCliente;
    }

    /**
     * @param pasaporteCliente the pasaporteCliente to set
     */
    public void setPasaporteCliente(String pasaporteCliente) {
        this.pasaporteCliente = pasaporteCliente;
    }

    /**
     * @return the codigoVuelo
     */
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    /**
     * @param codigoVuelo the codigoVuelo to set
     */
    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
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
        return this.getPasaporteCliente().equalsIgnoreCase(p.getPasaporteCliente()) && this.getCodigoVuelo().equals(p.getCodigoVuelo());
    }
    
    
    @Override
    public int compareTo(Pasaje p){       
        return this.getPasaporteCliente().compareTo(p.getPasaporteCliente());
        
    }
    
    
    
    
}
