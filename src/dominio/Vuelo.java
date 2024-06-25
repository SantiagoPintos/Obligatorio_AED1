
package dominio;

import tads.Cola;
import tads.ListaSimple;

public class Vuelo implements Comparable<Vuelo> {
    
    private String codigoVuelo;
    private Aerolinea aerolinea;
    private Avion codAvion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int año;
    private int cantPasajesEcon;
    private int cantPasajesPClase;
    private int cantPasajesEconVendidos;
    private int cantPasajesPClaseVendidos;
    private Cola listaPasajesPendientesEcon;
    private Cola listaPasajesPendientesPClase;
    
    
    public Vuelo(String codigoVuelo, Aerolinea aerolinea, Avion codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase, int cantPasajesEconVendidos, int cantPasajesPClaseVendidos){
        this.setCodigoVuelo(codigoVuelo);
        this.setAerolinea(aerolinea);
        this.setCodAvion(codAvion);
        this.setPaisDestino(paisDestino);
        this.setDia(dia);
        this.setMes(mes);
        this.setAño(año);
        this.setCantPasajesEcon(cantPasajesEcon);
        this.setCantPasajesPClase(cantPasajesPClase);
        this.setCantPasajesEconVendidos(cantPasajesEconVendidos);
        this.setCantPasajesPClaseVendidos(cantPasajesPClaseVendidos);
        this.listaPasajesPendientesEcon = new Cola(cantPasajesEcon);
        this.listaPasajesPendientesPClase = new Cola(cantPasajesPClase);
            
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
        return aerolinea.getNombre();
    }

    /**
     * @param aerolinea the aerolinea to set
     */
    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    /**
     * @return the codAvion
     */
    public String getCodAvion() {
        return codAvion.getCodigo();
    }

    /**
     * @param codAvion the codAvion to set
     */
    public void setCodAvion(Avion codAvion) {
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
    /**
     * @return the cantPasajesPClaseVendidos
     */
    public int getCantPasajesPClaseVendidos() {
        return cantPasajesPClaseVendidos;
    }
    /**
     * @return the cantPasajesEconVendidos
     */
    public int getCantPasajesEconVendidos() {
        return cantPasajesEconVendidos;
    }

    
    public void setCantPasajesPClaseVendidos(int cantPasajesPClaseVendidos) {
        this.cantPasajesPClaseVendidos = cantPasajesPClaseVendidos;
    }
    
    public void setCantPasajesEconVendidos(int cantPasajesEconVendidos) {
        this.cantPasajesEconVendidos = cantPasajesEconVendidos;
    }
        
    public Cola getPasajesPendientesEcon(){
        return this.listaPasajesPendientesEcon;
    }
    public Cola getPasajesPendientesPClase(){
        return this.listaPasajesPendientesPClase;
    }

    
    public boolean compararCodigoAvion(String codigo){
        return this.codAvion.getCodigo() == codigo;
    }
    
    public int getPasajesDisponibles(){
        int pasajesDisponibles = this.getCantPasajesEcon()+this.getCantPasajesPClase();
        pasajesDisponibles = pasajesDisponibles - (this.getCantPasajesEconVendidos()+this.getCantPasajesPClaseVendidos());
        return pasajesDisponibles;
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

    //Ejemplo de resultado: “ GH3344Y-Aerolineas Argentinas- AA211-2-0-7|”
    @Override
    public String toString(){        
        return this.getCodigoVuelo() + "-" + this.getAerolinea() + "-" + this.getCodAvion() + "-" + this.getCantPasajesEconVendidos() + "-" + this.getCantPasajesPClaseVendidos() + "-" + this.getPasajesDisponibles() + "|";
    }
}
