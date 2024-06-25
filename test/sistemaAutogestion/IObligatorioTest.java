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
        // Borrar aerolineas 
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
    public void testRegistrarCliente() {
        //Completar para segunda entrega
    }

    @Test
    public void testCrearVuelo() {
        //Completar para segunda entrega
    }

    @Test
    public void testComprarPasaje() {
        //Completar para segunda entrega
    }

    @Test
    public void testDevolverPasaje() {
        //Completar para segunda entrega
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

        r = miSistema.registrarAvion("AA345",12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB563",21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA311", 21, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.listarAvionesDeAerolinea("Aerolineas Argentinas");
        assertEquals("AA311-21|\nAA345-12|" , r.valorString);
        
        
        
    }

    @Test
    public void testListarClientes() {
        //Completar para segunda entrega
    }

    @Test
    public void testListarVuelos() {
        //Completar para segunda entrega
    }

    @Test
    public void testVuelosDeCliente() {
        //Completar para segunda entrega
    }

    @Test
    public void testPasajesDevueltos() {
        //Completar para segunda entrega
    }

    @Test
    public void testVistaDeVuelo() {
        //Completar para segunda entrega
    }

}
