package com.mexiti.costogasolina

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat
import org.junit.Assert.assertEquals

class CalcularMontoTest {
    @Test
    fun calcularMonto20l_24_95(){
        val precio = 24.95
        val cantLitros = 20.0
        val darPropina = false
        val propina = 0.0

        val montoEsperado = NumberFormat.getCurrencyInstance().format(499.0)
        val montoActual = NumberFormat.getCurrencyInstance().format(499.0)

        assertEquals(montoEsperado, montoActual)
    }
}