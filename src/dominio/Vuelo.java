
package dominio;


public class Vuelo implements Comparable<Vuelo> {
    
    private String codigoVuelo;
    private String aerolinea;
    private String codAvion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int año;
    private int cantPasajesEcon;
    private int cantPasajesPClase;
    
    
    public Vuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase){
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.codAvion = codAvion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.cantPasajesEcon = cantPasajesEcon;
        this.cantPasajesPClase = cantPasajesPClase;
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
     * @return the aerolinea
     */
    public String getAerolinea() {
        return aerolinea;
    }

    /**
     * @param aerolinea the aerolinea to set
     */
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    /**
     * @return the codAvion
     */
    public String getCodAvion() {
        return codAvion;
    }

    /**
     * @param codAvion the codAvion to set
     */
    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
    }

    /**
     * @return the paisDestino
     */
    public String getPaisDestino() {
        return paisDestino;
    }

    /**
     * @param paisDestino the paisDestino to set
     */
    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the año
     */
    public int getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * @return the cantPasajesEcon
     */
    public int getCantPasajesEcon() {
        return cantPasajesEcon;
    }

    /**
     * @param cantPasajesEcon the cantPasajesEcon to set
     */
    public void setCantPasajesEcon(int cantPasajesEcon) {
        this.cantPasajesEcon = cantPasajesEcon;
    }

    /**
     * @return the cantPasajesPClase
     */
    public int getCantPasajesPClase() {
        return cantPasajesPClase;
    }

    /**
     * @param cantPasajesPClase the cantPasajesPClase to set
     */
    public void setCantPasajesPClase(int cantPasajesPClase) {
        this.cantPasajesPClase = cantPasajesPClase;
    }
    
    
    public boolean compararCodigoAvion(String codigo){
        return this.codAvion == codigo;
    }
    
    
    
    @Override
    public boolean equals(Object c){
        Vuelo v = (Vuelo)c;
        return this.getCodigoVuelo().equalsIgnoreCase(v.getCodigoVuelo());
    }
    
    @Override
    public int compareTo(Vuelo v){
        return this.getCodigoVuelo().compareTo(v.getCodigoVuelo());
    }
}
