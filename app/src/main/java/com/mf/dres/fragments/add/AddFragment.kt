package com.mf.dres.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mf.dres.R
import com.mf.dres.model.Mueble
import com.mf.dres.viewmodel.MuebleViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var muebleViewModel: MuebleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        // View Model
        muebleViewModel = ViewModelProvider(this).get(MuebleViewModel::class.java)

        // Boton Agregar Mueble
        view.btnAdd.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val nombre = nombre_et.text.toString()
        val color = color_et.text.toString()
        val precio = precio_et.text
        val descripcion = descripcion_et.text.toString()

        if (inputCheck(nombre, color, precio, descripcion)) {
            // Create Object Mueble
            val mueble = Mueble(0, nombre, color, Integer.parseInt(precio.toString()), descripcion)
            // Add Data to Database
            muebleViewModel.addMueble(mueble)
            Toast.makeText(requireContext(), "Se guardo exitosamente!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Por favor llena todos los campos.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(nombre: String, color: String, precio: Editable, descripcion: String): Boolean {
        return !(TextUtils.isEmpty(nombre) || TextUtils.isEmpty(color) || precio.isEmpty() || TextUtils.isEmpty(descripcion))
    }
}