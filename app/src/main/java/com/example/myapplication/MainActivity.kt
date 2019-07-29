package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), ListCitiesFragment.OnCitySelectedListener {

    override fun onCitySelected(cityName: String) {
        val mainFlag = supportFragmentManager.findFragmentByTag("MainFragment") as MainFragment?
        if (mainFlag != null) {
            onBackPressed()
            mainFlag.setNameCity(cityName)
        } else{
            val newFragment = MainFragment()
            val args = Bundle()
            args.putString("cityName",cityName)
            newFragment.arguments = args
            supportFragmentManager.beginTransaction()
            ?.replace(R.id.container, newFragment)
            ?.addToBackStack(null)
            ?.commit()
         }
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            supportFragmentManager.beginTransaction()
                ?.replace(R.id.container, MainFragment(),"MainFragment")
                ?.addToBackStack("MainFragment")
                ?.commit()
        }


}
