package com.krisna.diva.temperatureconversion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ConvertActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var title: TextView
    private lateinit var result: TextView
    private lateinit var btnConvert: Button
    private lateinit var etInput: EditText

    companion object {
        const val TITLE = "title"
    }

    private fun initComponents() {
        title = findViewById(R.id.tv_title)
        result = findViewById(R.id.tv_result)
        btnConvert = findViewById(R.id.btn_convert)
        etInput = findViewById(R.id.et_input)
    }

    private fun initListeners() {
        btnConvert.setOnClickListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)

        initComponents()
        title.text = "${intent.getStringExtra(TITLE)}"
        initListeners()
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_convert) {
            val num = etInput.text.toString().trim()
            if (num.isEmpty()) {
                etInput.error = getString(R.string.empty)
            } else if (num.isNotEmpty()) {
                val res: String = when (title.text) {
                    getString(R.string.celcius) -> {
                        Temperature.convertTemperature(
                            this,
                            getString(R.string.celcius),
                            num.toDouble()
                        )
                    }

                    getString(R.string.fahrenheit) -> {
                        Temperature.convertTemperature(
                            this,
                            getString(R.string.fahrenheit),
                            num.toDouble()
                        )
                    }

                    getString(R.string.kelvin) -> {
                        Temperature.convertTemperature(
                            this,
                            getString(R.string.kelvin),
                            num.toDouble()
                        )
                    }

                    getString(R.string.reamur) -> {
                        Temperature.convertTemperature(
                            this,
                            getString(R.string.reamur),
                            num.toDouble()
                        )
                    }

                    else -> {
                        getString(R.string.invalid)
                    }
                }
                result.text = res
            }
        }
    }
}