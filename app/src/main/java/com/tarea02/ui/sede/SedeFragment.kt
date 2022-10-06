package com.tarea02.ui.sede

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tarea02.R
import com.tarea02.databinding.FragmentSedeBinding
import com.tarea02.viewmodel.SedeViewModel

class SedeFragment : Fragment() {

    private var _binding: FragmentSedeBinding? = null
    private val binding get() = _binding!!
    private lateinit var sedeViewModel: SedeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         sedeViewModel =  ViewModelProvider(this).get(SedeViewModel::class.java)
        _binding = FragmentSedeBinding.inflate(inflater, container, false)

        binding.addSedeFabBt.setOnClickListener {
            findNavController().navigate(R.id.action_nav_sede_to_addSedeFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}