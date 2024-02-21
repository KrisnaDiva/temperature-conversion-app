package com.krisna.diva.temperatureconversion

import android.content.Context
import kotlin.properties.Delegates

object Temperature {
    // late init hanya bisa untuk variable non primitive
    private lateinit var cel: String
    private lateinit var kel: String
    private lateinit var fah: String
    private lateinit var rea: String

//    jika Anda mencoba mengakses salah satu dari variabel ini sebelum memberikan nilai kepada mereka, maka akan menghasilkan IllegalStateException.
//    private var cel by Delegates.notNull<String>()
//    private var kel by Delegates.notNull<String>()
//    private var fah by Delegates.notNull<String>()
//    private var rea by Delegates.notNull<String>()

    private fun format(value: Double): String {
        return String.format("%.2f", value).replace(',', '.')
    }

    fun convertTemperature(context: Context, type: String, value: Double): String {
        val result: MutableList<String> = when (type) {
            context.getString(R.string.celcius) -> {
                fah = format(value * 1.8 + 32)
                kel = format(value + 273.15)
                rea = format(value * 0.8)
                mutableListOf("Fahrenheit: $fah", "Kelvin: $kel", "Reamur: $rea")
            }

            context.getString(R.string.fahrenheit) -> {
                cel = format((value - 32) / 1.8)
                kel = format((value + 459.67) * 5 / 9)
                rea = format((value - 32) * 4 / 9)
                mutableListOf("Celcius: $cel", "Kelvin: $kel", "Reamur: $rea")
            }

            context.getString(R.string.kelvin) -> {
                cel = format(value - 273.15)
                fah = format(value * 9 / 5 - 459.67)
                rea = format((value - 273.15) * 0.8)
                mutableListOf("Celcius: $cel", "Fahrenheit: $fah", "Reamur: $rea")
            }

            context.getString(R.string.reamur) -> {
                cel = format(value * 1.25)
                fah = format(value * 2.25 + 32)
                kel = format(value * 1.25 + 273.15)
                mutableListOf("Celcius: $cel", "Fahrenheit: $fah", "Kelvin: $kel")
            }

            else -> mutableListOf(context.getString(R.string.invalid))
        }
        result.add(0, context.getString(R.string.result))
        return result.joinToString("\n")
    }
}