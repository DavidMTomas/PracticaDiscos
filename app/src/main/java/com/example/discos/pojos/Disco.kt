package com.example.discos.pojos

import java.io.Serializable

data class Disco(var nombre: String, var anyio: Int, var lista:List<Cancion>):Serializable {

}
