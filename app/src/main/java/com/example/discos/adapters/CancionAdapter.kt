package com.example.discos.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.discos.R
import com.example.discos.databinding.ItemCancionBinding
import com.example.discos.pojos.Cancion

class CancionAdapter (val lista: List<Cancion>, var evento: EventoCancion) :
    RecyclerView.Adapter<CancionAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCancionBinding.bind(view)

        fun render(cancion: Cancion) {
            binding.tViewCancionNombre.text = cancion.nombre
            binding.tViewCancionTiempo.text = cancion.tiempo
            setEvento(cancion)
        }

        private fun setEvento(cancion: Cancion) {
            binding.root.setOnClickListener {
                evento.enviarEventoCancion(cancion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cancion, parent, false)
        )
    }


    override fun getItemCount(): Int = lista.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(lista[position])
    }

}