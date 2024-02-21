package com.krisna.diva.temperatureconversion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnCelcius: Button
    private lateinit var btnFahrenheit: Button
    private lateinit var btnKelvin: Button
    private lateinit var btnReamur: Button

    private fun initComponents() {
        btnCelcius = findViewById(R.id.btn_celcius)
        btnFahrenheit = findViewById(R.id.btn_fahrenheit)
        btnKelvin = findViewById(R.id.btn_kelvin)
        btnReamur = findViewById(R.id.btn_reamur)
    }

    private fun initListeners() {
        btnCelcius.setOnClickListener(this)
        btnFahrenheit.setOnClickListener(this)
        btnKelvin.setOnClickListener(this)
        btnReamur.setOnClickListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
    }

    override fun onClick(v: View?) {
        val convertIntent = Intent(this@MainActivity, ConvertActivity::class.java)
        when (v?.id) {
            R.id.btn_celcius -> {
                convertIntent.putExtra(ConvertActivity.TITLE, getString(R.string.celcius))
                startActivity(convertIntent)
            }

            R.id.btn_fahrenheit -> {
                convertIntent.putExtra(ConvertActivity.TITLE, getString(R.string.fahrenheit))
                startActivity(convertIntent)
            }

            R.id.btn_kelvin -> {
                convertIntent.putExtra(ConvertActivity.TITLE, getString(R.string.kelvin))
                startActivity(convertIntent)
            }

            R.id.btn_reamur -> {
                convertIntent.putExtra(ConvertActivity.TITLE, getString(R.string.reamur))
                startActivity(convertIntent)
            }
        }
    }
}