package com.example.discos.adapters

import com.example.discos.pojos.Cancion

interface EventoCancion {
    fun enviarEventoCancion(cancion: Cancion)
}