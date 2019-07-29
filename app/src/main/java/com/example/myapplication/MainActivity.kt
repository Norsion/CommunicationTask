package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), ListCitiesFragment.OnCitySelectedListener {

    override fun onCitySelected(cityName: String) {

        val mainFragment = MainFragment()
        val bundle = Bundle()
        bundle.putString("cityName", cityName)
        mainFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            ?.replace(R.id.container, mainFragment)
            ?.addToBackStack(null)
            ?.commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            ?.replace(R.id.container, MainFragment())
            ?.addToBackStack(null)
            ?.commit()
    }

}
