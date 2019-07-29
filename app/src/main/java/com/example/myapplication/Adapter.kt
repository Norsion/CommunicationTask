package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (var textitem: MutableList<String>, private val listener: ListCitiesFragment.OnCitySelectedListener?):RecyclerView.Adapter<Adapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false))
    }

    override fun getItemCount(): Int {
       return textitem.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.textView?.text = textitem[position]
        holder?.bind(listener)

    }


    inner class Holder(itemview:View):RecyclerView.ViewHolder(itemview){
        val textView:TextView? = itemview.findViewById(R.id.textView_city)

        fun bind(listener: ListCitiesFragment.OnCitySelectedListener?){
            textView?.setOnClickListener{
                listener?.onCitySelected(textView?.text.toString())
            }
        }

    }

}