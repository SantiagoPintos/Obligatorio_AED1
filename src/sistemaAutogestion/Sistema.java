package sistemaAutogestion;

import dominio.Aerolinea;
import dominio.Cliente;
import dominio.Vuelo;
import dominio.Avion;
import tads.ListaSimple;
import tads.Nodo;

public class Sistema implements IObligatorio {

    private ListaSimple<Vuelo> listaVuelos;
    private ListaSimple<Aerolinea> listaAerolineas;
    private ListaSimple<Cliente> listaClientes;

    @Override
    // Pre: listaVuelos, listaAerolineas y listaClientes declaradas
    // Post: listaVuelos, listaAerolineas y listaClientes inicializadas
    public Retorno crearSistemaDeGestion() {
        Retorno retorno = Retorno.ok();
        listaVuelos = new ListaSimple();
        listaAerolineas = new ListaSimple();
        listaClientes = new ListaSimple();
        if (listaVuelos != null && listaAerolineas != null && listaClientes != null) {
            retorno = Retorno.ok();
        }
        return retorno;
    }

    @Override
    // Pre: Recibir por parametro nombre, pais y cantidad maxima de aviones
    // Post: Devolver error o crear correctamente la aerolinea
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        Retorno retorno;
        Aerolinea aerolineaNueva = new Aerolinea(nombre, pais, cantMaxAviones);
        if (listaAerolineas.estaElemento(aerolineaNueva)) {
            retorno = Retorno.error1();
        } else if (cantMaxAviones <= 0) {
            retorno = Retorno.error2();
        } else {
            listaAerolineas.agregarOrd(aerolineaNueva);
            retorno = Retorno.ok();
        }
        return retorno;
    }

    @Override
    // Pre: Recibir el nombre de la aerolinea por parametro
    // Post: Comprobar si esta la aerolinea y eliminarla correctamente o devolver error
    public Retorno eliminarAerolinea(String nombre) {
        Retorno retorno;
        Nodo<Aerolinea> aerolineaBorrar = listaAerolineas.buscarElemento(new Aerolinea(nombre, "pais", 0));
        if (aerolineaBorrar == null) {
            retorno = Retorno.error1();
        } else if (aerolineaBorrar.getDato().getListaAviones().cantElementos() > 0) {
            retorno = Retorno.error2();
        } else {
            listaAerolineas.borrarElemento(aerolineaBorrar.getDato());
            retorno = Retorno.ok();
        }
        return retorno;
    }

    @Override
    // Pre: Recibir por parametro, codigo, capacidad maxima y nombre de aerolinea
    // Post: Verificar datos y retornar error o crear correctamente el avion
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        Retorno retorno;
        if (capacidadMax < 9 || capacidadMax % 3 != 0) {
            retorno = Retorno.error2();
        } else {
            Avion nuevoAvion = new Avion(codigo, capacidadMax, nomAerolinea);
            Nodo<Aerolinea> aerolineaBuscada = listaAerolineas.buscarElemento(new Aerolinea(nomAerolinea, "pais", 0));
            if (aerolineaBuscada != null) {
                if (aerolineaBuscada.getDato().getListaAviones().cantElementos() == aerolineaBuscada.getDato().getCantMaxAviones()) {
                    retorno = Retorno.error4();
                } else if (aerolineaBuscada.getDato().getListaAviones().estaElemento(nuevoAvion)) {
                    retorno = Retorno.error1();
                } else {
                    aerolineaBuscada.getDato().getListaAviones().agregarOrd(nuevoAvion);
                    retorno = Retorno.ok();
                }
            } else {
                retorno = Retorno.error3();
            }
        }
        return retorno;
    }

    @Override
    // Pre: Se reciben los datos del nombre de la aerolinea y el codigo del avion a eliminar
    // Post: Se verifican los datos y se retorna error u Ok
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        Retorno retorno = Retorno.error1();
        int largo = listaVuelos.cantElementos();
        Nodo<Vuelo> aux = listaVuelos.getInicio();
        // Crear aerolinea para verificar si existe ese nombre       
        Nodo<Aerolinea> aerolineaBuscada = listaAerolineas.buscarElemento(new Aerolinea(nomAerolinea, "pais", 0));
        // Si la aerolinea no es nula, creo el avion para verificar que exista un avion con ese codigo
        if (aerolineaBuscada != null) {
            Nodo<Avion> avionAborrar = aerolineaBuscada.getDato().getListaAviones().buscarElemento(new Avion(codAvion, 0, nomAerolinea));
            // Si el avion existe verificamos que no tenga vuelos con pasajes vendidos
            if (avionAborrar != null) {
                boolean sePuedeEliminar = true;
                // Recorremos vuelos verificando si se puede eliminar el avion y si existe un vuelo
                while (aux != null && sePuedeEliminar == true) {
                    // Comparamos el codigo de avion recibido con el codigo de avion del vuelo
                    if (aux.getDato().compararCodigoAvion(codAvion.trim())) {
                        // comparamos la cantidad de pasajes vendidos de TODOS los vuelos en los que ese avion haya estado involucrado (Para eso se crea la variable sePuedeEliminar)
                        if (aux.getDato().getCantPasajesEcon() > 0 || aux.getDato().getCantPasajesPClase() > 0) {
                            sePuedeEliminar = false;
                            retorno = Retorno.error3();
                        }
                    }
                    // Siguiente vuelo
                    aux = aux.getSiguiente();
                }
                // El avion se puede eliminar
                if (sePuedeEliminar == true) {
                    aerolineaBuscada.getDato().getListaAviones().borrarElemento(avionAborrar.getDato());
                    retorno = Retorno.ok();
                }
            } else {
                retorno = Retorno.error2();

            }
        }

        return retorno;
    }

    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        Retorno retorno = Retorno.noImplementada();
        return retorno;
    }

    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        Retorno retorno = Retorno.noImplementada();
        return retorno;
    }

    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        Retorno retorno = Retorno.noImplementada();
        return retorno;
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo
    ) {
        Retorno retorno = Retorno.noImplementada();
        return retorno;
    }

    @Override
    // Pre: Existe listaAerolineas
    // Post: Se retorno un string con la lista de las aerolineas
    public Retorno listarAerolineas() {
        Retorno retorno = Retorno.ok();
        Nodo<Aerolinea> aux = listaAerolineas.getInicio();
        retorno.valorString = "";
        while (aux != null) {
            retorno.valorString += aux.getDato().toString();
            if (aux.getSiguiente() != null) {
                retorno.valorString += "\n";
            }
            aux = aux.getSiguiente();
        }
        return retorno;
    }

    @Override
    // Pre: Se recibe un nombre de una aerolinea
    // Post: Se retorna un string con los datos de los aviones de esa aerolinea
    public Retorno listarAvionesDeAerolinea(String nombre) {
        Retorno retorno = Retorno.ok();
        Nodo<Aerolinea> aerolinea = listaAerolineas.buscarElemento(new Aerolinea(nombre, "pais", 3));
        retorno.valorString = "";
        if (aerolinea != null) {
            Nodo<Avion> aux = aerolinea.getDato().getListaAviones().getInicio();
            while (aux != null) {
                retorno.valorString += aux.getDato().toString();
                if (aux.getSiguiente() != null) {
                    retorno.valorString += "\n";
                }

                aux = aux.getSiguiente();
            }
        } else {
            retorno = Retorno.error1();
        }
        return retorno;
    }

    @Override
    public Retorno listarClientes() {
        Retorno retorno = Retorno.noImplementada();
        return retorno;
    }

    @Override
    public Retorno listarVuelos() {
        Retorno retorno = Retorno.noImplementada();
        return retorno;
    }

    @Override
    public Retorno vuelosDeCliente(String pasaporte
    ) {
        Retorno retorno = Retorno.noImplementada();
        return retorno;
    }

    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea
    ) {
        Retorno retorno = Retorno.noImplementada();
        return retorno;
    }

    @Override
    public Retorno vistaDeVuelo(String codigoVuelo
    ) {
        Retorno retorno = Retorno.noImplementada();
        return retorno;
    }

}
