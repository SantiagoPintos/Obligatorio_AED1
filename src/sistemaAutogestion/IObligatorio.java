package sistemaAutogestion;

public interface IObligatorio {

    /*
    **************** REGISTROS **************************************
     */
    // pre: listaVuelos, listaAerolineas y listaClientes declaradas
    // post:listaVuelos, listaAerolineas y listaClientes inicializadas     
    public Retorno crearSistemaDeGestion();

    ;
    // Pre: Recibir por parametro nombre, pais y cantidad maxima de aviones
    // Post: Devolver error o crear correctamente la aerolinea
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones);
    // Pre: Recibir el nombre de la aerolinea por parametro
    // Post: Comprobar si esta la aerolinea y eliminarla correctamente o devolver error
    public Retorno eliminarAerolinea(String nombre);

    ; 
    // Pre: Recibir por parametro, codigo, capacidad maxima y nombre de aerolinea
    // Post: Verificar datos y retornar error o crear correctamente el avion
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea);

    ; 
    // Pre: Se reciben los datos del nombre de la aerolinea y el codigo del avion a eliminar
    // Post: Se verifican los datos y se retorna error u Ok
    public Retorno eliminarAvion(String nomAerolinea, String codAvion);

    //pre:      post:
    public Retorno registrarCliente(String pasaporte, String nombre, int edad);
    //pre:      post:

    /*
    **************** GESTIÓN DE VUELOS Y PASAJES **************************************
     */
    //pre:      post:
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase);

    //pre:      post:
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje);

    //pre:      post:
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo);

    /*
    **************** REPORTES Y CONSULTAS **************************************
     */
    // Pre: Existe listaAerolineas
    // Post: Se retorno un string con la lista de las aerolineas
    public Retorno listarAerolineas();

    // Pre: Se recibe un nombre de una aerolinea
    // Post: Se retorna un string con los datos de los aviones de esa aerolinea
    public Retorno listarAvionesDeAerolinea(String nombre);

    //pre:      post: 
    public Retorno listarClientes();

    //pre:      post: 
    public Retorno listarVuelos();

    //pre:      post: 
    public Retorno vuelosDeCliente(String pasaporte);

    //pre:      post: 
    public Retorno pasajesDevueltos(String nombreAerolinea);

    //pre:      post: 
    public Retorno vistaDeVuelo(String codigoVuelo);

}
