package dev.anto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        
        cuenta = new Cuenta(1000, 12);
    }

    @Test
    void testConsignar() {
        cuenta.consignar(500);
        assertEquals(1500, cuenta.saldo, 0.01);
        assertEquals(1, cuenta.numConsignaciones);
    }

    @Test
    void testRetirar_SaldoSuficiente() {
    boolean resultado = cuenta.retirar(300);
    System.out.println("Resultado del retiro: " + resultado);
    System.out.println("Saldo después del retiro: " + cuenta.saldo);
    System.out.println("Número de retiros: " + cuenta.numRetiros);
    
    assertTrue(resultado);
    assertEquals(700, cuenta.saldo, 0.01);
    assertEquals(1, cuenta.numRetiros);
}

    

    @Test
    void testRetirar_SaldoInsuficiente() {
        boolean resultado = cuenta.retirar(1200);
        assertFalse(resultado);
        assertEquals(1000, cuenta.saldo, 0.01);
        assertEquals(0, cuenta.numRetiros);
    }

    @Test
    void testCalcularInteresMensual() {
        cuenta.calcularInteresMensual();
        assertEquals(1010, cuenta.saldo, 0.01); 
    }
    @Test
     void testExtractoMensual() {
     cuenta.comisionMensual = 10;
     cuenta.extractoMensual();
     assertEquals(999.9, cuenta.saldo, 0.01); 
}

    @Test
    void testImprimir() {
        cuenta.imprimir(); 
    }
}

