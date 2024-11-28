package com.example.discos.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.discos.R
import com.example.discos.databinding.ItemDiscoBinding
import com.example.discos.pojos.Disco

class DiscoAdapter(val lista: ArrayList<Disco>, var eventoDisco: EventoDisco) :
    RecyclerView.Adapter<DiscoAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemDiscoBinding.bind(view)

        fun render(disco: Disco) {
            binding.tViewDiscoNombre.text = disco.nombre
            binding.tViewAnyo.text = disco.anyio.toString()
            setEvento(disco)
        }

        private fun setEvento(disco: Disco) {
            binding.root.setOnClickListener {
                eventoDisco.enviarEvento(disco)
                Log.v("enviado", "hola")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_disco,
           parent,false))
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(lista[position])
    }
}