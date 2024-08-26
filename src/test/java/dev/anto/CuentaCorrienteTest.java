package dev.anto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {

     private CuentaCorriente cuentaCorriente;

    @BeforeEach
    public void setUp() {
        cuentaCorriente = new CuentaCorriente(1000.0f, 0.12f); 
    }

    @Test
    public void testRetirarSinSobregiro() {
        cuentaCorriente.retirar(500.0f);
        assertEquals(500.0f, cuentaCorriente.saldo, 0.001f);
        assertEquals(0.0f, cuentaCorriente.sobregiro, 0.001f);
    }

    @Test
    public void testRetirarConSobregiro() {
        cuentaCorriente.retirar(1500.0f);
        assertEquals(0.0f, cuentaCorriente.saldo, 0.001f);
        assertEquals(500.0f, cuentaCorriente.sobregiro, 0.001f);
    }

    @Test
    public void testConsignarParaCubrirSobregiro() {
        cuentaCorriente.retirar(1500.0f); 
        cuentaCorriente.consignar(700.0f); 
        assertEquals(200.0f, cuentaCorriente.saldo, 0.001f);
        assertEquals(0.0f, cuentaCorriente.sobregiro, 0.001f);
    }

    @Test
    public void testConsignarSinSobregiro() {
        cuentaCorriente.consignar(500.0f);
        assertEquals(1500.0f, cuentaCorriente.saldo, 0.001f);
        assertEquals(0.0f, cuentaCorriente.sobregiro, 0.001f);
    }

    @Test
    public void testExtractoMensual() {
        cuentaCorriente.retirar(1500.0f); 
        cuentaCorriente.comMensual = 10.0f;
        cuentaCorriente.extractoMensual();
        
        assertEquals(0.0f, cuentaCorriente.saldo, 0.001f);
        assertEquals(510.0f, cuentaCorriente.sobregiro, 0.001f);
        assertEquals(10.0f, cuentaCorriente.comMensual, 0.001f);
    }

    @Test
    public void testImprimir() {
        cuentaCorriente.retirar(1200.0f); 
        cuentaCorriente.consignar(300.0f); 
        cuentaCorriente.imprimir();
        
    }
}