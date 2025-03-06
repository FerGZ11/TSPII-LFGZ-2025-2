package com.example.listacomida.data

import com.example.listacomida.R
import com.example.listacomida.model.Platillo

class DataSource {
    fun LoadPlatillos(): List<Platillo> {
        return listOf<Platillo>(
            Platillo(R.string.desayuno, R.drawable.desayuno, 100.0, 20 ),
            Platillo(R.string.hamburguesa, R.drawable.hamburguesa, 120.0, 25 ),
            Platillo(R.string.pizza, R.drawable.pizza, 250.0, 30 ),
            Platillo(R.string.postre, R.drawable.postre, 70.0, 10 ),
            Platillo(R.string.pozole, R.drawable.pozole, 95.0, 15 ),
            Platillo(R.string.tacos, R.drawable.tacos, 90.0, 10 ),
        )
    }
}