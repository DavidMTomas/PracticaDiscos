package com.example.discos.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.discos.R
import com.example.discos.adapters.EventoDisco
import com.example.discos.adapters.EventoCancion
import com.example.discos.databinding.ActivityMainBinding
import com.example.discos.fragments.CancionFragment
import com.example.discos.fragments.DiscoFragment
import com.example.discos.pojos.Cancion
import com.example.discos.pojos.Disco

class MainActivity : AppCompatActivity(), EventoDisco, EventoCancion {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Inicio
        if (savedInstanceState == null) {
            val transaccion = supportFragmentManager.beginTransaction()
            transaccion.replace(R.id.contFragmentDisco, DiscoFragment())
            transaccion.commitNow()
        }
    }

    //Evento
    override fun enviarEvento(t: Disco) {
        //Pasamos el disco al fragment canciones
        val canciones=CancionFragment.newInstance(t)
        val transaccion = supportFragmentManager.beginTransaction()
        transaccion.replace(R.id.contFragmenCancion, canciones) // Lo pasamos como parametro

        transaccion.addToBackStack(null)
        transaccion.commit()
    }

    override fun enviarEventoCancion(cancion: Cancion) {
       Toast.makeText(this,"Hola",Toast.LENGTH_LONG).show()
    }
}