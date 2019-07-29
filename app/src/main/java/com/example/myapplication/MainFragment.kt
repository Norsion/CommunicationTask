package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments == null)  tv_city.text = "Ваш город" else tv_city?.text = arguments?.getString("cityName")

        btn_select.setOnClickListener {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.container, ListCitiesFragment())
                    ?.addToBackStack(null)
                    ?.commit()
        }
    }
}