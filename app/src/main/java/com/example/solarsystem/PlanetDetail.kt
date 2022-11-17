@file:Suppress("DEPRECATION")

package com.example.solarsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import kotlinx.android.synthetic.main.activity_planet_detail.*

class PlanetDetail : AppCompatActivity() {
    private lateinit var obj:PlanetData
    private var planetImg:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)
        window.decorView.apply { systemUiVisibility= SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }

        obj=intent.getParcelableExtra("planet")!!
        planetImg=intent.getIntExtra("planetImg",-1)
        setData(obj, planetImg!!)

        button_info.setOnClickListener{
            val intent=Intent(this,FinalActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setData(obj:PlanetData,planetImg:Int){
        title_info.text=obj.title
        distance_info.text=obj.distance+"m km"
        gravity_info.text=obj.gravity+" m/ss"
        overview_info.text=obj.overView
        galaxy_info.text
        obj.galaxy
        planet_img_info.setImageResource(planetImg)
    }
}