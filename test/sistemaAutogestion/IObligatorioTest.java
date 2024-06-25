/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tads.ListaSimple;

/**
 *
 * @author pesce
 */
public class IObligatorioTest {

    private Sistema miSistema;

    public IObligatorioTest() {
    }

    @Before
    public void setUp() {
        miSistema = new Sistema();
    }

    @Test
    public void testCrearSistemaDeGestion() {
        Retorno r = miSistema.crearSistemaDeGestion();
        assertEquals(Retorno.Resultado.OK, r.resultado);
    }

    @Test
    public void testCrearAerolineaOK() {
        miSistema.crearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 15);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("FlyEmirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emiratess", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fli Emirates", "Dubai", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea(" ", "Portugal", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

    }

    @Test
    public void testCrearAerolineaError1() {
        miSistema.crearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 15);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.crearAerolinea("fly emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.crearAerolinea("aerolineas uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaError2() {
        miSistema.crearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", -2);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 0);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", -1);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", -3);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", -59874359);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 0);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", -3);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaOK() {
        miSistema.crearSistemaDeGestion();
        // Crear para borrar
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 15);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 12);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Borrar aerolineas wqertyqwerty
        r = miSistema.eliminarAerolinea("Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.eliminarAerolinea("Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.eliminarAerolinea("fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaError1() {
        miSistema.crearSistemaDeGestion();
        // Crear aerolineas a eliminar
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 15);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 15);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Eliminar Aerolineas
        r = miSistema.eliminarAerolinea("Aerolineas Uruguayy");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.eliminarAerolinea("PIuna");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.eliminarAerolinea("Fli Emirates");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("TAP Portugal");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaError2() {
        miSistema.crearSistemaDeGestion();
        // Creamos aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 15);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registramos aviones
        r = miSistema.registrarAvion("AWF345", 15, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("AWF346", 15, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Eliminamos aerolineas
        r = miSistema.eliminarAerolinea("Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.eliminarAerolinea("Pluna");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionOK() {
        miSistema.crearSistemaDeGestion();

        // Creamos la aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 15);
        assertEquals(Retorno.Resultado.OK, r.resultado);

        // Registramos avion
        r = miSistema.registrarAvion("AWF345", 15, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("AWF345", 15, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("AWF346", 15, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("AWF347", 12, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionError1() {
        miSistema.crearSistemaDeGestion();
        // Crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);

        // Crear avion Aerolinas Uruguay
        r = miSistema.registrarAvion("AWF345", 15, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("AWF345", 15, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);

        // Crear avion Pluna
        r = miSistema.registrarAvion("EFT51", 15, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Pluna");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA700", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 18, "Aerolineas Argentinas");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionError2() {
        miSistema.crearSistemaDeGestion();
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("AWF345", 6, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.registrarAvion("AWF346", 17, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 8, "Pluna");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.registrarAvion("EFT52", 16, "Pluna");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 3, "Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 14, "Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionError3() {
        miSistema.crearSistemaDeGestion();
        // Crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguayy");
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Plunas");
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Aerolineas  Uruguay");
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Porter Airlines");
        assertEquals(Retorno.error3().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionError4() {
        miSistema.crearSistemaDeGestion();
        // Crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 3);
        assertEquals(Retorno.Resultado.OK, r.resultado);

        // Registrar aviones Aerolineas Uruguay OK
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones Aerolineas Uruguay ERROR 4
        r = miSistema.registrarAvion("FGU765", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.ERROR_4, r.resultado);

        // Registrar aviones Pluna OK
        r = miSistema.registrarAvion("EFT51", 15, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("AWF345", 12, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("KLO902", 9, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        // Registrar aviones Pluna ERROR 4
        r = miSistema.registrarAvion("HGFD123", 21, "Pluna");
        assertEquals(Retorno.Resultado.ERROR_4, r.resultado);

        //Datos de prueba brindados por el docente
        // No hay
    }

    @Test
    public void testEliminarAvionOK() {
        miSistema.crearSistemaDeGestion();
        // Crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("747WX", 15, "Fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Eliminar aviones
        r = miSistema.eliminarAvion("Aerolineas Uruguay", "EFT51");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Uruguay", "AWF345");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.eliminarAvion("Fly Emirates", "747WX");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA345");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionError1() {
        miSistema.crearSistemaDeGestion();
        // Crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar avion
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("AWF345", 15, "Fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Eliminar avion
        r = miSistema.eliminarAvion("Aerolineas  Uruguay", "EFT51");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Uruguayy", "EFT51");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.eliminarAvion("Fli Emirates", "AWF345");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.eliminarAvion("FlyEmirates", "AWF345");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Gol Brasil", "AA345");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionError2() {
        miSistema.crearSistemaDeGestion();
        // Crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        // Eliminar aviones
        r = miSistema.eliminarAvion("Aerolineas Uruguay", "EFT511");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Uruguay", "AMF345");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Uruguay", "");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "YY111");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarClienteOk() {
        miSistema.crearSistemaDeGestion();
        Retorno r = miSistema.registrarCliente("1234567", "Martin Diaz", 20);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("8233569", "Pedro Rodriguez", 26);
        assertEquals(Retorno.Resultado.OK, r.resultado);
    }

    @Test
    public void testRegistrarClienteError1() {
        miSistema.crearSistemaDeGestion();
        Retorno r = miSistema.registrarCliente("1234567", "Martin Diaz", -2);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.registrarCliente("6534568", "Juan Perez", -1);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.registrarCliente("8233569", "Pedro Rodriguez", -15);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
    }

    @Test
    public void testRegistrarClienteError2() {
        miSistema.crearSistemaDeGestion();
        Retorno r = miSistema.registrarCliente("12345671", "Martin Diaz", 20);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.registrarCliente("534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.registrarCliente("43248233569", "Pedro Rodriguez", 26);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
    }

    @Test
    public void testRegistrarClienteError3() {
        miSistema.crearSistemaDeGestion();
        // Crear clientes correctamente
        Retorno r = miSistema.registrarCliente("1234567", "Martin Diaz", 20);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("8233569", "Pedro Rodriguez", 26);
        assertEquals(Retorno.Resultado.OK, r.resultado);

        // Clientes duplicado
        r = miSistema.registrarCliente("1234567", "Martin Diaz", 20);
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);
        r = miSistema.registrarCliente("8233569", "Pedro Rodriguez", 26);
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);

    }

    @Test
    public void testCrearVueloOk() {
        miSistema.crearSistemaDeGestion();
        // Creamos aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registramos Aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Creamos vuelo
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("435435", "Fly Emirates", "EFT51", "Brasil", 15, 8, 2025, 9, 3);
        assertEquals(Retorno.Resultado.OK, r.resultado);
    }

    @Test
    public void testCrearVueloError1() {
        miSistema.crearSistemaDeGestion();
        // Creamos aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registramos Aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Creamos vuelo
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("43543534", "Aerolineas Uruguay", "AWF345", "Portugal", 27, 6, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("43543543", "Fly Emirates", "EFT51", "Brasil", 15, 8, 2025, 9, 3);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.crearVuelo("43543534", "Aerolineas Uruguay", "AWF345", "Portugal", 27, 6, 2024, 12, 6);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
    }

    @Test
    public void testCrearVueloError2() {
        miSistema.crearSistemaDeGestion();
        // Creamos aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registramos Aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Creamos vuelo
        r = miSistema.crearVuelo("43543543", "AerolineasUruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.crearVuelo("43543534", "Fly Emiratess", "AWF345", "Portugal", 27, 6, 2024, 12, 6);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
    }

    @Test
    public void testCrearVueloError3() {
        miSistema.crearSistemaDeGestion();
        // Creamos aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registramos Aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Creamos vuelo
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF346", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);
        r = miSistema.crearVuelo("4354354324", "Fly Emirates", "EFT52", "Portugal", 27, 6, 2024, 12, 6);
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);
    }

    @Test
    public void testCrearVueloError4() {
        miSistema.crearSistemaDeGestion();
        // Creamos aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registramos Aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Creamos vuelo
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("43543534", "Fly Emirates", "EFT51", "Portugal", 27, 6, 2024, 12, 3);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("6543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.ERROR_4, r.resultado);
        r = miSistema.crearVuelo("4354", "Fly Emirates", "EFT51", "Portugal", 27, 6, 2024, 12, 3);
        assertEquals(Retorno.Resultado.ERROR_4, r.resultado);
    }

    @Test
    public void testCrearVueloError5() {
        miSistema.crearSistemaDeGestion();
        // Creamos aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registramos Aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Creamos vuelo
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 11, 6);
        assertEquals(Retorno.Resultado.ERROR_5, r.resultado);
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 5);
        assertEquals(Retorno.Resultado.ERROR_5, r.resultado);
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 10, 4);
        assertEquals(Retorno.Resultado.ERROR_5, r.resultado);

    }

    @Test
    public void testCrearVueloError6() {
        miSistema.crearSistemaDeGestion();
        // Creamos aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registramos Aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Fly Emirates");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Creamos vuelo
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 9, 12);
        assertEquals(Retorno.Resultado.ERROR_6, r.resultado);
        r = miSistema.crearVuelo("435435432143", "Fly Emirates", "EFT51", "Portugal", 22, 4, 2024, 9, 9);
        assertEquals(Retorno.Resultado.ERROR_6, r.resultado);
    }

    @Test
    public void testComprarPasajeOk() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 10);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("7856436", "Santiago Diaz", 23);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Pluna", "EFT51", "Luxemburgo", 11, 7, 2024, 12, 3);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("6534568", "43543543", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("7856436", "98754397", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
    }

    @Test
    public void testComprarPasajeError1() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 10);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("7856436", "Santiago Diaz", 23);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Pluna", "EFT51", "Luxemburgo", 11, 7, 2024, 12, 3);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("65345686", "43543543", 1);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.comprarPasaje("78564361", "98754397", 2);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
    }

    @Test
    public void testComprarPasajeError2() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 10);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 15, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("7856436", "Santiago Diaz", 23);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Pluna", "EFT51", "Luxemburgo", 11, 7, 2024, 12, 3);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("6534568", "43543542", 1);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.comprarPasaje("7856436", "98754398", 2);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
    }

    @Test
    public void testDevolverPasajeOk() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 10);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 12, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("7856436", "Santiago Diaz", 23);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("5345345", "Ticiano Gonzalez", 20);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("0921340", "Pepe Rodriguez", 25);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("1239547", "Sandra Perez", 44);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("5439210", "Laura Fernandez", 29);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Pluna", "EFT51", "Luxemburgo", 11, 7, 2024, 3, 9);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("6534568", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Pasajes para vuelo 2
        r = miSistema.comprarPasaje("7856436", "98754397", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("5345345", "98754397", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("0921340", "98754397", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("1239547", "98754397", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("5439210", "98754397", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Devolver pasajes
        r = miSistema.devolverPasaje("6534568", "43543543");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.devolverPasaje("7856436", "98754397");
        assertEquals(Retorno.Resultado.OK, r.resultado);
    }

    @Test
    public void testDevolverPasajeError1() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 10);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 12, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("7856436", "Santiago Diaz", 23);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Pluna", "EFT51", "Luxemburgo", 11, 7, 2024, 3, 9);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("6534568", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("7856436", "98754397", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Devolver pasajes
        r = miSistema.devolverPasaje("6534561", "43543543");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        r = miSistema.devolverPasaje("7856435", "98754397");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
    }

    @Test
    public void testDevolverPasajeError2() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 10);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 12, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("7856436", "Santiago Diaz", 23);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Pluna", "EFT51", "Luxemburgo", 11, 7, 2024, 3, 9);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("6534568", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("7856436", "98754397", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Devolver pasajes
        r = miSistema.devolverPasaje("6534568", "33543543");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
        r = miSistema.devolverPasaje("7856436", "98754396");
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
    }

    @Test
    public void testDevolverPasajeError3() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 10);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 12, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Pluna", "EFT51", "Luxemburgo", 11, 7, 2024, 3, 9);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("6534568", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Devolver pasajes
        r = miSistema.devolverPasaje("6534568", "98754397");
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);
    }

    @Test
    public void testListarAerolineas() {
        miSistema.crearSistemaDeGestion();
        // Crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 9);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Fly Emirates", "Dubai", 5);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarAerolineas();
        assertEquals("Aerolineas Uruguay-Uruguay-5|\nFly Emirates-Dubai-5|\nPluna-Uruguay-9|", r.valorString);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarAerolineas();
        // Se modifica el valor esperado, agregando las aerolineas ya registradas por nosotros.
        assertEquals("Aerolineas Argentinas-Argentina-10|\nAerolineas Uruguay-Uruguay-5|\nCopa Airlines-Panamá-30|\nDelta Air Lines-Estados Unidos-30|\nFly Emirates-Dubai-5|\nIberia-España-20|\nPluna-Uruguay-9|", r.valorString);
    }

    @Test
    public void testListarAvionesDeAerolinea() {
        miSistema.crearSistemaDeGestion();
        // Crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);

        // Crear avion Aerolinas Uruguay
        r = miSistema.registrarAvion("AWF345", 15, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("AWF346", 12, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        // Crear avion Pluna
        r = miSistema.registrarAvion("EFT51", 15, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT52", 15, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        // Listar aviones
        r = miSistema.listarAvionesDeAerolinea("Aerolineas Uruguay");
        assertEquals("AWF345-15|\nAWF346-12|", r.valorString);
        r = miSistema.listarAvionesDeAerolinea("Pluna");
        assertEquals("EFT51-15|\nEFT52-15|", r.valorString);

        //Datos de prueba brindados por el docente
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB563", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA311", 21, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.listarAvionesDeAerolinea("Aerolineas Argentinas");
        assertEquals("AA311-21|\nAA345-12|", r.valorString);

    }

    @Test
    public void testListarClientes() {
        miSistema.crearSistemaDeGestion();
        // Registrar Clientes
        Retorno r = miSistema.registrarCliente("1234567", "Martin Diaz", 20);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("8233569", "Pedro Rodriguez", 26);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.listarClientes();
        assertEquals("8233569-Pedro Rodriguez-26|\n6534568-Juan Perez-28|\n1234567-Martin Diaz-20|", r.valorString);
    }

    @Test
    public void testListarVuelos() {
        miSistema.crearSistemaDeGestion();
        // Creamos aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registramos Aviones
        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("AA211", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Creamos vuelo
        r = miSistema.crearVuelo("GH3344Y", "Aerolineas Argentinas", "AA211", "Brasil", 15, 8, 2025, 3, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("KJD234G", "Aerolineas Argentinas", "AA345", "Portugal", 22, 4, 2024, 3, 3);
        assertEquals(Retorno.Resultado.OK, r.resultado);

        //vuelos deben estar en formato KJD234G-Aerolineas Argentinas- AA345-3-3-6|
        //por lo tanto la salida debe ser: 43543543-Aerolineas Uruguay-AWF345-22-4-2024-12-6| 435435-Fly Emirates-EFT51-15-8-2025-9-3| 
        r = miSistema.listarVuelos();
        assertEquals("KJD234G-Aerolineas Argentinas-AA345-0-0-6|\nGH3344Y-Aerolineas Argentinas-AA211-0-0-9|", r.valorString);

    }

    @Test
    public void testVuelosDeClienteOk() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 10);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 12, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Pluna", "EFT51", "Luxemburgo", 11, 7, 2024, 3, 9);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("6534568", "43543543", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("6534568", "98754397", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Devolver pasaje
        r = miSistema.devolverPasaje("6534568", "43543543");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Listar pasajes cliente
        r = miSistema.vuelosDeCliente("6534568");
        assertEquals("98754397-CPR|\n43543543-CPR|\n43543543-DEV|\n", r.valorString);
    }
    @Test
    public void testVuelosDeClienteError1() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 10);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 12, "Pluna");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Pluna", "EFT51", "Luxemburgo", 11, 7, 2024, 3, 9);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("6534568", "43543543", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("6534568", "98754397", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Devolver pasaje
        r = miSistema.devolverPasaje("6534568", "43543543");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Listar pasajes cliente
        r = miSistema.vuelosDeCliente("6534567");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
    }

    @Test
    public void testPasajesDevueltosOk() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 12, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Aerolineas Uruguay", "EFT51", "Luxemburgo", 11, 7, 2024, 3, 9);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("6534568", "43543543", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("6534568", "98754397", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Devolver pasaje
        r = miSistema.devolverPasaje("6534568", "43543543");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.devolverPasaje("6534568", "98754397");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Listar devolver pasajes
        r = miSistema.pasajesDevueltos("Aerolineas Uruguay");
        assertEquals("6534568-98754397|\n6534568-43543543|", r.valorString);
    }
    @Test
    public void testPasajesDevueltosError1() {
        miSistema.crearSistemaDeGestion();
        // Registrar aerolineas
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar aviones
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarAvion("EFT51", 12, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar Clientes
        r = miSistema.registrarCliente("6534568", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Registrar vuelos
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.crearVuelo("98754397", "Aerolineas Uruguay", "EFT51", "Luxemburgo", 11, 7, 2024, 3, 9);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Crear pasaje
        r = miSistema.comprarPasaje("6534568", "43543543", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("6534568", "98754397", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Devolver pasaje
        r = miSistema.devolverPasaje("6534568", "43543543");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.devolverPasaje("6534568", "98754397");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        // Listar devolver pasajes
        r = miSistema.pasajesDevueltos("Aerolineas Uruguayy");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
    }

    @Test
    public void testVistaDeVuelo() {
        //Completar para segunda entrega
        miSistema.crearSistemaDeGestion();
        //areolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Uruguay", "Uruguay", 5);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        //avion
        r = miSistema.registrarAvion("AWF345", 18, "Aerolineas Uruguay");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        //vuelo
        r = miSistema.crearVuelo("43543543", "Aerolineas Uruguay", "AWF345", "Portugal", 22, 4, 2024, 12, 6);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        //clientes
        r = miSistema.registrarCliente("2332331", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("2332330", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("1322731", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("7772331", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("1334555", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("3265522", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("3445566", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("3344441", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("8453222", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.registrarCliente("8045450", "Juan Perez", 28);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        //pasaje
        r = miSistema.comprarPasaje("2332331", "43543543", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("2332330", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("1322731", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("7772331", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("1334555", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("3265522", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("3445566", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("3344441", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("8453222", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r = miSistema.comprarPasaje("8045450", "43543543", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);

        r = miSistema.vistaDeVuelo("43543543");
        assertEquals(Retorno.Resultado.OK, r.resultado);
    }

}
