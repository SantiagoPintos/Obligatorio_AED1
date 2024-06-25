package dominio;

public class Avion implements Comparable<Avion>{

    private String codigo;
    private int capacidadMax;
    private Aerolinea aerolinea;

    public Avion(String codigo, int capacidadMax, Aerolinea aerolinea) {
        this.setCodigo(codigo);
        this.setCapacidadMax(capacidadMax);
        this.setNomAeroLinea(aerolinea);
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the capacidadMax
     */
    public int getCapacidadMax() {
        return capacidadMax;
    }

    /**
     * @param capacidadMax the capacidadMax to set
     */
    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    /**
     * @return the nomAeroLinea
     */
    public Aerolinea getNomAeroLinea() {
        return aerolinea;
    }

    /**
     * @param nomAeroLinea the nomAeroLinea to set
     */
    public void setNomAeroLinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    @Override
    public boolean equals(Object c) {
        Avion a = (Avion) c;
        return this.getCodigo().equalsIgnoreCase(a.getCodigo());
    }
    
    @Override
    public int compareTo(Avion a){
        return this.getCodigo().compareTo(a.getCodigo());
    }
    
    
    @Override 
    public String toString(){
        return this.codigo + "-" + this.capacidadMax + "|";
    }
    
    

}
