package com.example.discos.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.discos.adapters.DiscoAdapter
import com.example.discos.adapters.EventoDisco
import com.example.discos.databinding.FragmentDiscoBinding
import com.example.discos.pojos.Disco
import com.example.discos.pojos.DiscoDatos


class DiscoFragment : Fragment() {
    lateinit var binding: FragmentDiscoBinding
    lateinit var adapterDisco: DiscoAdapter
    lateinit var layoutMan: LinearLayoutManager
    lateinit var eventoDisco: EventoDisco

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiscoBinding.inflate(inflater, container, false)
        eventoDisco = requireActivity() as EventoDisco
        adapterDisco = DiscoAdapter(DiscoDatos.listaDiscos, eventoDisco)
        layoutMan=LinearLayoutManager(context)

        binding.recViewDisco.apply {
            if(DiscoDatos.listaDiscos.isNotEmpty()){
                adapter=adapterDisco
                layoutManager=layoutMan
            } else {
                Log.e("DiscoFragment", "La lista de discos está vacía")
            }

        }
        return binding.root
    }
}