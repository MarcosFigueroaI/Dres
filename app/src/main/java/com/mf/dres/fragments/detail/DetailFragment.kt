package com.mf.dres.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mf.dres.R
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val mueble = args.currentMueble
        view.nombreDetalle_tv.setText(mueble.nombre)
        view.colorDetalle_tv.setText(mueble.color)
        view.precioDetalle_tv.setText("$${mueble.precio.toString()}")
        view.descripcionDetalle_tv.setText(mueble.descripcion)



        return view
    }
}