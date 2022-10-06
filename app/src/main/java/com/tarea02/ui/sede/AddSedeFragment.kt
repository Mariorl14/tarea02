package com.tarea02.ui.lugar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tarea02.R
import com.tarea02.databinding.FragmentAddSedeBinding
import com.tarea02.model.Sede
import com.tarea02.viewmodel.SedeViewModel

class AddSedeFragment : Fragment() {

    private var _binding: FragmentAddSedeBinding? = null
    private val binding get() = _binding!!
    private lateinit var sedeViewModel: SedeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sedeViewModel =  ViewModelProvider(this).get(SedeViewModel::class.java)
        _binding = FragmentAddSedeBinding.inflate(inflater, container, false)

        binding.btAddSede.setOnClickListener { addSede() }

        return binding.root
    }

    private fun addSede() {
        val nombre = binding.etNombre.text.toString()
        val web  = binding.etWeb.text.toString()

        if (nombre.isNotEmpty()){
            val sede = Sede(0,nombre,web,0.0,0.0,0.0,"","")
            sedeViewModel.saveSede(sede)
            Toast.makeText(requireContext(),getString(R.string.msg_sede_added),
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addSedeFragment_to_nav_sede)
        }else {
            Toast.makeText(requireContext(),getString(R.string.msg_data),
                Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}