package dominio;

public class Avion implements Comparable<Avion>{

    private String codigo;
    private int capacidadMax;
    private String nomAeroLinea;

    public Avion(String codigo, int capacidadMax, String nomAeroLinea) {
        this.codigo = codigo;
        this.capacidadMax = capacidadMax;
        this.nomAeroLinea = nomAeroLinea;
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
    public String getNomAeroLinea() {
        return nomAeroLinea;
    }

    /**
     * @param nomAeroLinea the nomAeroLinea to set
     */
    public void setNomAeroLinea(String nomAeroLinea) {
        this.nomAeroLinea = nomAeroLinea;
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
