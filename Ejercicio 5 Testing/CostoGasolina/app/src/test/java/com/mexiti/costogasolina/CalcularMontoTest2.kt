package com.mexiti.costogasolina

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat
import org.junit.Assert.assertEquals

class CalcularMontoTest2 {
    @Test
    fun calcularMonto40l_22_35() {
        val precio = 22.35
        val cantLitros = 40.0
        val darPropina = false
        val propina = 0.0

        val montoEsperado = NumberFormat.getCurrencyInstance().format(precio * cantLitros)
        val montoActual = NumberFormat.getCurrencyInstance().format(22.35 * 40.0)

        assertEquals(montoEsperado, montoActual)
    }
}