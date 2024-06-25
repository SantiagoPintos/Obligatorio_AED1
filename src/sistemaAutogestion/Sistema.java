package sistemaAutogestion;

import dominio.Aerolinea;
import dominio.Cliente;
import dominio.Vuelo;
import dominio.Avion;
import dominio.Pasaje;
import tads.ListaSimple;
// Consultar
import tads.Nodo;

public class Sistema implements IObligatorio {

    // Consultar las listas guardadas y las listas guardadas en las clases tambien
    private ListaSimple<Vuelo> listaVuelos;
    private ListaSimple<Aerolinea> listaAerolineas;
    private ListaSimple<Cliente> listaClientes;

    @Override
    // Pre: listaVuelos, listaAerolineas y listaClientes declaradas
    // Post: listaVuelos, listaAerolineas y listaClientes inicializadas
    public Retorno crearSistemaDeGestion() {
        Retorno retorno = Retorno.noImplementada();
        listaVuelos = new ListaSimple();
        listaAerolineas = new ListaSimple();
        listaClientes = new ListaSimple();
        if (listaVuelos != null && listaAerolineas != null && listaClientes != null) {
            retorno = Retorno.ok();
        }
        return retorno;
    }

    @Override
    // Pre: Recibir por parametro: "nombre" de tipo String no vacío, "pais" de tipo String no vacío y
    // cantMaxAviones de tipo entero y perteneciente a los números naturales
    // Post: Retornar error 1 si existe una aerolínea con ese nombre o error 2 si el parámetro cantMaxAviones
    // es menor o igual a 0
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
    // Pre: Recibir el parámetro "nombre" de tipo String no vacío correspondiente al nombre de la aerolínea
    // Post: Retornar ok y eliminar dicha aerolínea, retornar error 1
    // en caso de que no se encuentre una aerolínea con ese nombre, ó retornar errror 2 en caso de que exista la aerolínea
    // pero tenga aviones registrados
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
    // Pre: Recibir los parámetros "codigo" de tipo String no vacío, "capacidadMax" de tipo entero perteneciente a los números reales y 
    // mayor o igual a 9, "nomAerolinea" de tipo String no vacío
    // Post: Retornar ok si se registra la aerolínea, error 1 si el código de avión ya existe dentro de la aerolínea, error 2 
    // si el parámetro "capacidadMax" es menor que 9 o no es múltiplo de 3, o error 3 si la aerolínea no existe en la lista de aerolíneas
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        Retorno retorno;
        if (capacidadMax < 9 || capacidadMax % 3 != 0) {
            retorno = Retorno.error2();
        } else {
            Nodo<Aerolinea> aerolineaBuscada = listaAerolineas.buscarElemento(new Aerolinea(nomAerolinea, "pais", 0));
            if (aerolineaBuscada != null) {
                Avion nuevoAvion = new Avion(codigo, capacidadMax, aerolineaBuscada.getDato());
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
    // Pre: Se reciben los parámetros nomAerolinea de tipo String no vacío y codAvion de tipo String no vacío
    // Post: El método retorna ok si el avión es eliminado con éxito, 
    // error 1 Si la aerolínea nomAerolinea no existe, error 2 si el código de avión codAvion no existe dentro de la aerolínea,
    // error 3 si el avión con el código recibido en el parámetro "codAvion" tiene algún viaje con pasajes vendidos
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        Retorno retorno = Retorno.error1();
        Nodo<Vuelo> aux = listaVuelos.getInicio();
        // Crear aerolinea para verificar si existe ese nombre       
        Nodo<Aerolinea> aerolineaBuscada = listaAerolineas.buscarElemento(new Aerolinea(nomAerolinea, "pais", 0));
        // Si la aerolinea no es nula, creo el avion para verificar que exista un avion con ese codigo
        if (aerolineaBuscada != null) {
            Nodo<Avion> avionAborrar = aerolineaBuscada.getDato().getListaAviones().buscarElemento(new Avion(codAvion, 0, aerolineaBuscada.getDato()));
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
    // Pre: Se reciben los parámetros "pasaporte" de tipo String que no debe ser una cadena vacía y debe tener exactamente 7 caracteres alfanuméricos,
    // "nombre" de tipo String y que no debe ser una cadena vacía y "edad" de tipo entero perteneciente a los números naturales y mayor o igual a 0.
    // Post: Si el cliente se registra con éxito, el método retorna ok, 
    // si "edad" es menor que 0, el método retorna error 1,
    // Si el parámetro "pasaporte" no tiene 7 caracteres el método retorna error 2.
    // Si ya existe un cliente con el pasaporte recibido en el parámetro "pasaporte" el método retorna error 3.
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        Retorno retorno = Retorno.error1();
        // Verificamos edad
        if (edad >= 0) {
            // Verificamos largo del pasaporte
            if (pasaporte.length() == 7) {
                // Creamos cliente para comparar
                Cliente cliente = new Cliente(pasaporte, nombre, edad);
                // Verificar si existe el cliente con ese pasaporte
                Nodo<Cliente> clienteBuscado = listaClientes.buscarElemento(cliente);
                if (clienteBuscado == null) {
                    listaClientes.agregarInicio(cliente);
                    retorno = Retorno.ok();
                } else {
                    retorno = Retorno.error3();
                }
            } else {
                retorno = Retorno.error2();
            }
        }
        return retorno;
    }

    @Override
    // Pre: Los parámetros "codigoVuelo", "aerolinea", "codAvion" y "paisDestino" deben ser de tipo String y no contener una cadena vacía,
    //"dia", "mes" y "año" deben ser de tipo entero positivo perteneciente a los números reales.
    //"cantPasajesEcon" y "cantPasajesPClase" deben ser de tipo entero, número natural, mayor o igual a 3 y múltiplo de 3.
    // Post: Si el vuelo se crea con éxito, el método retorna ok.
    // Si ya existe el código de vuelo recibido en el parámetro "codigoVuelo" en el sistema, el método retorna error 1.
    // Si la aerolínea con el nombre recibido en el parámetro "aerolinea" no existe en el sistema, el método retorna error 2.
    // Si el código de avión recibido en el parámetro "codAvion" no existe dentro de la aerolínea "aerolinea", el método retorna error 3.
    // Si existe un vuelo creado para el avión "codAvion" en la fecha recibida en los parámetros "dia", "mes" y "año", el método retorna error 4.
    // Si las cantidades de pasajes recibidas en los parámetros "cantPasajesEcon" o "cantPasajesPClase" no son múltiplos de 3, el método retorna error 5.
    // Si la suma de los pasajes de ambas categorías supera la cantidad máxima permitida por el avión correspondiente al parámetro
    //"codAvion", el método retorna error 6.
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        Retorno retorno = Retorno.error1();
        Nodo<Aerolinea> aerolineaBuscada = listaAerolineas.buscarElemento(new Aerolinea(aerolinea, "", 5));
        Nodo<Avion> avionBuscado = null;
        boolean existeCodigo = listaVuelos.estaElemento(new Vuelo(codigoVuelo, new Aerolinea(aerolinea, "", 5), new Avion(codAvion, 12, new Aerolinea(aerolinea, "", 5)), "finlandia", 22, 06, 2024, 15, 16, 0, 0));
        boolean existeAerolinea = listaAerolineas.estaElemento(new Aerolinea(aerolinea, "pais", 10));
        boolean existeAvion = false;
        if (aerolineaBuscada != null) {
            avionBuscado = aerolineaBuscada.getDato().getListaAviones().buscarElemento(new Avion(codAvion, 12, new Aerolinea(aerolinea, "", 5)));
            existeAvion = aerolineaBuscada.getDato().getListaAviones().estaElemento(new Avion(codAvion, 15, new Aerolinea(aerolinea, "", 5)));
        }
        Nodo<Vuelo> aux = listaVuelos.getInicio();
        boolean existeVueloDeAvion = false;
        while (aux != null && existeVueloDeAvion == false) {
            if (aux.getDato().getCodAvion().equals(codAvion) && aux.getDato().getDia() == dia && aux.getDato().getMes() == mes && aux.getDato().getAño() == año) {
                existeVueloDeAvion = true;
            }
            aux = aux.getSiguiente();
        }
        if (!existeCodigo) {
            if (existeAerolinea) {
                if (existeAvion) {
                    if (!existeVueloDeAvion) {
                        if (cantPasajesEcon % 3 == 0 && cantPasajesPClase % 3 == 0) {
                            Nodo<Avion> avionSenuelo = aerolineaBuscada.getDato().getListaAviones().buscarElemento(new Avion(codAvion, 15, aerolineaBuscada.getDato()));
                            if (cantPasajesEcon + cantPasajesPClase <= avionSenuelo.getDato().getCapacidadMax()) {
                                Vuelo vuelo = new Vuelo(codigoVuelo, aerolineaBuscada.getDato(), avionBuscado.getDato(), paisDestino, dia, mes, año, cantPasajesEcon, cantPasajesPClase, 0, 0);
                                listaVuelos.agregarInicio(vuelo);
                                retorno = Retorno.ok();
                            } else {
                                retorno = Retorno.error6();
                            }
                        } else {
                            retorno = Retorno.error5();
                        }
                    } else {
                        retorno = Retorno.error4();
                    }
                } else {
                    retorno = Retorno.error3();
                }
            } else {
                retorno = Retorno.error2();
            }
        } else {
            retorno = Retorno.error1();
        }

        return retorno;
    }

    @Override
    // Pre: Recibir los parámetros "pasaporteCliente", "codigoVuelo" de tipo String no vacíos, y "categoríaPasaje" 
    // de tipo entero positivo, perteneciente a los números reales y que sea mayor o igual a 1 y menor o igual a 2
    // Post: el método retorna ok si el pasaje se emite correctamente.
    // Si el pasaporte del cliente recibido en el parámetro "pasaporteCliente" no existe, el método retorna error 1.
    // Si el código de vuelo recibido en el parámetro "codigoVuelo" no existe, el método retorna error 2.
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        Retorno retorno = Retorno.error1();
        Nodo<Cliente> cliente = listaClientes.buscarElemento(new Cliente(pasaporteCliente, "nombre", 0));
        Nodo<Vuelo> vuelo = listaVuelos.buscarElemento(new Vuelo(codigoVuelo, new Aerolinea("nombre", "pais", 3), new Avion("codigo", 9, new Aerolinea("nombre", "pais", 3)), "pais", 0, 0, 0, 0, 0, 0, 0));

        if (cliente != null) {
            if (vuelo != null) {
                Pasaje pasaje = new Pasaje(cliente.getDato(), vuelo.getDato(), categoríaPasaje, "Emitido");
                if (categoríaPasaje == 1) {
                    if (vuelo.getDato().getCantPasajesEconVendidos() < vuelo.getDato().getCantPasajesEcon()) {
                        cliente.getDato().getPasajesComprados().agregarInicio(pasaje);
                        // Sumamos uno a los pasajes economicos vendidos
                        vuelo.getDato().setCantPasajesEconVendidos(vuelo.getDato().getCantPasajesEconVendidos() + 1);
                        retorno = Retorno.ok();
                    } else {
                        pasaje.setEstado("Pendiente");
                        vuelo.getDato().getPasajesPendientesEcon().encolar(pasaje);
                        retorno = Retorno.ok();
                    }
                }
                if (categoríaPasaje == 2) {
                    if (vuelo.getDato().getCantPasajesPClaseVendidos() < vuelo.getDato().getCantPasajesPClase()) {
                        cliente.getDato().getPasajesComprados().agregarInicio(pasaje);
                        // Sumamos uno a los pasajes de primera clase vendidos
                        vuelo.getDato().setCantPasajesPClaseVendidos(vuelo.getDato().getCantPasajesPClaseVendidos() + 1);
                        retorno = Retorno.ok();
                    } else {
                        pasaje.setEstado("Pendiente");
                        vuelo.getDato().getPasajesPendientesPClase().encolar(pasaje);
                        retorno = Retorno.ok();
                    }
                }
            } else {
                retorno = Retorno.error2();
            }
        } else {
            retorno = Retorno.error1();
        }

        return retorno;
    }

    @Override
    // Pre: Recibir los parámetros "pasaporteCliente" y "codigoVuelo" de tipo String no vacío.
    // Post: El método retorna ok si se realiza la devolución del pasaje, 
    // Si el pasaporte del cliente recibido en el parámetro "pasaporteCliente" no existe, retorna error 1
    // Si el código de vuelo recibido en el parámetro "codigoVuelo" no existe, el método retorna error 2.
    // Si no existe una compra del cliente correspondiente al parámetro "pasaporteCliente" para el vuelo 
    // correspondiente al parámetro "codigoVuelo", el método retorna error 3.
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {        
        Retorno retorno = Retorno.error4();
        Nodo<Cliente> cliente = listaClientes.buscarElemento(new Cliente(pasaporteCliente, "martin", 0));
        Nodo<Vuelo> vuelo = listaVuelos.buscarElemento(new Vuelo(codigoVuelo, new Aerolinea("nombre", "pais", 3), new Avion("codigo", 9, new Aerolinea("nombre", "pais", 3)), "peru", 22, 06, 2023, 15, 16, 0, 0));
        if (cliente != null) {
            if (vuelo != null) {
                // Buscamos un pasaje de ese cliente                
                Nodo<Pasaje> pasaje = cliente.getDato().getPasajesComprados().buscarElemento(new Pasaje(cliente.getDato(), vuelo.getDato(), 0, "Emitido"));
                // Verificamos si existe un pasaje comprado de ese cliente                
                if (pasaje != null) {
                    if (pasaje.getDato().getCategoriaPasaje() == 1) {
                        // Restamos un pasaje a ese vuelo
                        vuelo.getDato().setCantPasajesEconVendidos(vuelo.getDato().getCantPasajesEconVendidos() - 1);
                        // Agregamos el pasaje del cliente a la lista de sus pasajes devueltos
                        cliente.getDato().getPasajesDevueltos().agregarInicio(pasaje.getDato());
                        // Confirmamos la devolucion
                        retorno = Retorno.ok();
                       
                        if (vuelo.getDato().getPasajesPendientesEcon().cantElementos() > 0) {
                            // Obtenemos el siguiente pasaje pendiente
                            Nodo<Pasaje> pasajeAAgregar = vuelo.getDato().getPasajesPendientesEcon().getInicio();
                            // Eliminamos el pasaje de los pendientes
                            vuelo.getDato().getPasajesPendientesEcon().desencolar();
                            Nodo<Cliente> clienteAAgregar = listaClientes.buscarElemento(new Cliente(pasajeAAgregar.getDato().getPasaporteCliente().getPasaporte(), "Juan", 2));
                            pasajeAAgregar.getDato().setEstado("Emitido");
                            // Agregamos el pasaje comprado a ese cliente
                            clienteAAgregar.getDato().getPasajesComprados().agregarInicio(pasajeAAgregar.getDato());
                            // Si se emite un pasaje pendiente agregamos un pasaje a ese vuelo
                            vuelo.getDato().setCantPasajesEconVendidos(vuelo.getDato().getCantPasajesEconVendidos() + 1);
                            retorno = Retorno.ok();
                        }
                    }
                    if (pasaje.getDato().getCategoriaPasaje() == 2) {
                        // Restamos un pasaje a ese vuelo
                        vuelo.getDato().setCantPasajesPClaseVendidos(vuelo.getDato().getCantPasajesPClaseVendidos() - 1);
                        // Agregamos el pasaje del cliente a la lista de sus pasajes devueltos
                        cliente.getDato().getPasajesDevueltos().agregarInicio(pasaje.getDato());
                        // Confirmamos la devolucion del pasaje
                        retorno = Retorno.ok();
                        if (vuelo.getDato().getPasajesPendientesPClase().cantElementos() > 0) {
                            // Obtenemos el siguiente pasaje pendiente
                            Nodo<Pasaje> pasajeAAgregar = vuelo.getDato().getPasajesPendientesPClase().getInicio();
                            // Eliminamos el pasaje de los pendientes
                            vuelo.getDato().getPasajesPendientesPClase().desencolar();
                            Nodo<Cliente> clienteAAgregar = listaClientes.buscarElemento(new Cliente(pasajeAAgregar.getDato().getPasaporteCliente().getPasaporte(), "Juan", 2));
                            pasajeAAgregar.getDato().setEstado("Emitido");
                            // Agregamos el pasaje comprado a ese cliente
                            clienteAAgregar.getDato().getPasajesComprados().agregarInicio(pasajeAAgregar.getDato());
                            // Si se emite un pasaje pendiente agregamos un pasaje a ese vuelo
                            vuelo.getDato().setCantPasajesPClaseVendidos(vuelo.getDato().getCantPasajesEconVendidos() + 1);
                            retorno = Retorno.ok();
                        }
                    }

                } else {
                    retorno = Retorno.error3();
                }
            } else {
                retorno = Retorno.error2();
            }
        } else {
            retorno = Retorno.error1();
        }
        return retorno;
    }

    @Override
    // Pre: En el sistema existe la lista "listaAerolineas" no vacía
    // Post: Se muestran en pantalla nombre de aerolínea, país y la cantidad máxima de aviones para cada una de las aerolíneas
    // en la lista, y se retorna ok.
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
// Pre: Se recibe el parámetro "nombre" de tipo String no vacío, en el sistema existe una lista de aerolíneas y cada 
    // aerolínea tiene inicializada una lista de aviones.
    // Post: Se retorna un string con los datos de cada uno de los aviones de esa aerolínea o error 1 en caso de que
    // no se encuentre una aerolínea con el nombre recibido en el parámetro "nombre".
    public Retorno listarAvionesDeAerolinea(String nombre
    ) {
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
    //Pre: En el sistema existe y está inicializada una lista de clientes ordenados según su registro.
    //post: El método retorna ok y una cadena de texto que contiene pasaporte, nombre y edad de cada uno de los clientes contenidos en la lista.
    public Retorno listarClientes() {
        Retorno retorno = Retorno.ok();
        retorno.valorString = "";
        retorno = listarClientesRecursivo(listaClientes.getInicio(), retorno);
        return retorno;
    }

    public Retorno listarClientesRecursivo(Nodo<Cliente> cliente, Retorno retorno) {
        if (cliente == null) {
            return retorno;
        }

        retorno.valorString += cliente.getDato().toString();
        if (cliente.getSiguiente() != null) {
            retorno.valorString += "\n";
        }
        return listarClientesRecursivo(cliente.getSiguiente(), retorno);
    }

    @Override
    //Pre: En el sistema existe y está inicializada una lista que contiene todos los vuelos.
    //Post: El método retorna ok y una cadena de tipo String que contiene los datos de cada uno de los vuelos contenidos en la lista.
    public Retorno listarVuelos() {
        Retorno retorno = Retorno.ok();
        retorno.valorString = "";
        Nodo<Vuelo> aux = listaVuelos.getInicio();
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
    //Pre: Se recibe el parámetro "pasaporte" de tipo String no vacío
    //Post: El método retorna ok y una cadena de tipo String que contiene todos los vuelos del cliente al que corresponda el pasaporte 
    //"pasaporte" recibido por parámetro, incluyendo los devueltos, o retornar error 1 en caso de que no exista un cliente 
    //que tenga asociado dicho pasaporte.
    public Retorno vuelosDeCliente(String pasaporte) {
        Retorno retorno = Retorno.ok();
        Nodo<Cliente> cliente = listaClientes.buscarElemento(new Cliente(pasaporte, "nombre", 0));
        if (cliente == null) {
            return Retorno.error1();
        }
        retorno.valorString = "";
        retorno = vuelosDeClienteRecursivo(cliente.getDato().getPasajesComprados().getInicio(), "CPR", retorno);
        retorno = vuelosDeClienteRecursivo(cliente.getDato().getPasajesDevueltos().getInicio(), "DEV", retorno);
        return retorno;
    }

    public Retorno vuelosDeClienteRecursivo(Nodo<Pasaje> pasaje, String estado, Retorno retorno) {
        if (pasaje == null) {
            return retorno;
        }
        retorno.valorString += pasaje.getDato().toString();
        retorno.valorString += "-";
        retorno.valorString += estado;
        retorno.valorString += "|";
        retorno.valorString += "\n";

        return vuelosDeClienteRecursivo(pasaje.getSiguiente(), estado, retorno);
    }

    @Override
    // Pre: Se recibe por parámetro "nombreAerolinea" de tipo String no vacío
    // Post: El método retorna ok y una cadena de texto que contenga pasaporte de cliente y código de vuelo para todos los vuelos
    // que han sido devueltos, o error 1 en caso de que no exista una aerolínea con un nombre coincidiente al recibido por parámetro
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        Retorno retorno = Retorno.error2();
        Nodo<Aerolinea> aerolinea = listaAerolineas.buscarElemento(new Aerolinea(nombreAerolinea, "pais", 5));
        retorno.valorString = "";
        if (aerolinea != null) {
            Nodo<Cliente> clienteAux = listaClientes.getInicio();
            while (clienteAux != null) {
                Nodo<Pasaje> pasajeAux = clienteAux.getDato().getPasajesComprados().getInicio();
                while (pasajeAux != null) {
                    Nodo<Vuelo> vueloAux = listaVuelos.buscarElemento(new Vuelo(pasajeAux.getDato().getCodigoVuelo().getCodigoVuelo(), new Aerolinea("nombre", "pais", 3), new Avion("codigo", 9, new Aerolinea("nombre", "pais", 3)), "", 0, 0, 0, 0, 0, 0, 0));
                    if (vueloAux.getDato().getAerolinea().equals(nombreAerolinea)) {
                        retorno.valorString += pasajeAux.getDato().getPasaporteCliente().getPasaporte();
                        retorno.valorString += "-";
                        retorno.valorString += pasajeAux.getDato().toString();
                        retorno.valorString += "|";
                        if (pasajeAux.getSiguiente() != null) {
                            retorno.valorString += "\n";
                        }
                    }
                    pasajeAux = pasajeAux.getSiguiente();
                }
                clienteAux = clienteAux.getSiguiente();
            }

        } else {
            retorno = Retorno.error1();
        }
        return retorno;
    }

    @Override
    //Pre: Se recibe por parámetro "codigoVuelo" de tipo String no vacío
    //Post: Se muestra un reporte el cual contiene una representación de la distribución de pasajeros dentro del avión
    //separados por clase (primera y económica) y mostrando los asientos ocupados (mostrando pasaporte de cliente) y
    // libres (mostrando los caracteres "XXXXXXX").
    public Retorno vistaDeVuelo(String codigoVuelo) {
        Retorno retorno = Retorno.ok();
        Nodo<Vuelo> vueloAux = listaVuelos.buscarElemento(new Vuelo(codigoVuelo, new Aerolinea("", "", 0), new Avion("", 0, new Aerolinea("", "", 0)), "", 0, 0, 0, 0, 0, 0, 0));
        //listas que van a almacenar los clientes que viajaron en el vuelo dado
        ListaSimple<Cliente> listaPasaportesPrimeraClase = new ListaSimple();
        ListaSimple<Cliente> listaPasaportesEcon = new ListaSimple();

        //se populan las listas con los clientes que viajaron en las respectivas clases del vuelo dado
        Nodo<Cliente> clienteAux = listaClientes.getInicio();
        while (clienteAux != null) {
            Nodo<Pasaje> pasajeAux = clienteAux.getDato().getPasajesComprados().buscarElemento(new Pasaje(clienteAux.getDato(), vueloAux.getDato(), 0, ""));
            if (pasajeAux != null && pasajeAux.getDato().getCodigoVuelo().equals(vueloAux.getDato())) {
                //verificar si es PClase o Econ, por letra sabemos que 1 es econ y 2 PClase
                if (pasajeAux.getDato().getCategoriaPasaje() == 1) {
                    listaPasaportesPrimeraClase.agregarFinal(clienteAux.getDato());
                } else {
                    listaPasaportesEcon.agregarFinal(clienteAux.getDato());
                }
            }
            clienteAux = clienteAux.getSiguiente();
        }

        //se obtienen la cantidad de pasajes totales para conocer las dimensiones de la matriz
        int cantPasajesPClase = vueloAux.getDato().getCantPasajesPClase();
        int cantPasajesEcon = vueloAux.getDato().getCantPasajesEcon();

        //Se calcula la cantidad de filas que va a tener la matriz, redondeando hacia arriba
        //se le suman 2 porque uno corresponde a título "PRIMERA" y el otro a "ECONÓMICA"
        int cantFilas = (int) Math.ceil((cantPasajesPClase + cantPasajesEcon + 2) / 3.0);
        String[][] matriz = new String[cantFilas][3];
        //se inicializa la matriz con XXXX que luego serán reemplazados con los pasaportes de los clientes
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = "XXXXXXXX";
            }
        }
        //se coloca el título de la clase en la posición central de la primera fila
        matriz[0][1] = "PRIMERA";
        //se recorre matriz agregando pasaportes de clientes que viajaron en primera clase
        Nodo<Cliente> clienteAuxPrimera = listaPasaportesPrimeraClase.getInicio();
        //se recorre la matriz de esta manera porque es necesario controlar que el cliente no sea nulo y la posición de la matriz al mismo tiempo
        int fila = 1;
        int columna = 0;
        boolean filaAgregada = false;
        while (clienteAuxPrimera != null) {
            filaAgregada = false;
            matriz[fila][columna] = clienteAuxPrimera.getDato().getPasaporte();
            clienteAuxPrimera = clienteAuxPrimera.getSiguiente();
            columna++;
            if (columna == 3) {
                columna = 0;
                fila++;
                filaAgregada = true;
            }
        }
        if (columna != 3 && filaAgregada == false) {
            fila++;
        }
        //se coloca el título de la clase en la posición central de la fila siguiente a la de primera clase
        matriz[fila][1] = "ECONOMICA";
        Nodo<Cliente> clienteAuxEcon = listaPasaportesEcon.getInicio();
        fila++;
        columna = 0;
        while (clienteAuxEcon != null) {
            matriz[fila][columna] = clienteAuxEcon.getDato().getPasaporte();
            clienteAuxEcon = clienteAuxEcon.getSiguiente();
            columna++;
            if (columna == 3) {
                columna = 0;
                fila++;
            }
        }
        retorno.valorString = "";
        //Se imprime en pantalla la matriz, agregando un salto de línea al final de cada fila y separando los pasaportes con un espacio
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < 3; j++) {
                retorno.valorString += matriz[i][j];
                if (j != 2) {
                    retorno.valorString += " ";
                }
            }
            retorno.valorString += "\n";
        }
        System.out.println("Vista de pasajes: ");
        System.out.println(retorno.valorString);

        return retorno;
    }

}
