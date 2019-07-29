package com.example.myapplication


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_cities.*


class ListCitiesFragment : Fragment() {

    private var mOnCitySelectedListener: OnCitySelectedListener? = null


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnCitySelectedListener) {
            mOnCitySelectedListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        mOnCitySelectedListener = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_cities, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = Adapter(getCities(), mOnCitySelectedListener)


    }

    private fun getCities(): MutableList<String> {
        val cities = mutableListOf<String>()
        cities.add("Moskow")
        cities.add("Saratov")
        cities.add("Tokio")
        cities.add("Paris")
        cities.add("New-York")
        return cities
    }


    interface OnCitySelectedListener {
        fun onCitySelected(cityName: String)
    }

}