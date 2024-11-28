package com.example.discos.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.discos.adapters.CancionAdapter
import com.example.discos.adapters.EventoCancion
import com.example.discos.databinding.FragmentCancionBinding
import com.example.discos.pojos.Disco

class CancionFragment : Fragment() {
    lateinit var binding: FragmentCancionBinding
    lateinit var adapterCancion: CancionAdapter
    lateinit var linearLayoutMan: LinearLayoutManager
    lateinit var itemDecoration: DividerItemDecoration
    lateinit var evento: EventoCancion

    companion object {
        // Método para crear la instancia del fragmento y pasar el disco
        fun newInstance(disco: Disco): CancionFragment {
            val fragment = CancionFragment()
            val bundle = Bundle()
            bundle.putSerializable("disco", disco)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCancionBinding.inflate(inflater, container, false)

        val disco = arguments?.getSerializable("disco") as? Disco
        if (disco != null) {

            val listado = disco.lista
            evento = requireActivity() as EventoCancion
            adapterCancion = CancionAdapter(listado, evento)
            linearLayoutMan = LinearLayoutManager(context)
            itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

            binding.recViewCancion.apply {
                adapter = adapterCancion
                layoutManager = linearLayoutMan
                addItemDecoration(itemDecoration)
            }
        }
        else {
            Log.e("CancionFragment", "No se pasó el disco correctamente.")
        }

        return binding.root
    }
}