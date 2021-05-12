package com.mf.dres.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mf.dres.R
import com.mf.dres.model.Mueble
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var muebleList = emptyList<Mueble>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return muebleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = muebleList[position]
        holder.itemView.nombre_tv.text = currentItem.nombre
        holder.itemView.color_tv.text = currentItem.color
        holder.itemView.precio_tv.text = "$${currentItem.precio.toString()}"

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(mueble: List<Mueble>) {
        this.muebleList = mueble
        notifyDataSetChanged()
    }
}