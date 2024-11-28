package com.example.discos.adapters

import com.example.discos.pojos.Disco

interface EventoDisco {
    fun enviarEvento(disco: Disco)
}
