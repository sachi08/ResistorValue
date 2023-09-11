package com.santiagogarciav.resistorvalue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    fun color_view(color: String): Double {
        return when (color) {
            "Black" -> 0.0
            "Brown" -> 1.0
            "Red" -> 2.0
            "Orange" -> 3.0
            "Yellow" -> 4.0
            "Green" -> 5.0
            "Blue" -> 6.0
            "Purple" -> 7.0
            "Gray" -> 8.0
            "White" -> 9.0

            else -> 0.0
        }
    }

    fun tolerance_view(color: String): String {
        return when (color) {
            "Brown" -> "Tolerancia 1%"
            "Red" -> "Tolerancia 2%"
            "Gold" -> "Tolerancia 5%"
            "Silver" -> "Tolerancia 10%"

            else -> ""
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.omh_text_View)

        val calculator = findViewById<Button>(R.id.calculator_button)
        val color_one = findViewById<Spinner>(R.id.fringe_one_spinner)
        val color_two = findViewById<Spinner>(R.id.fringe_two_spinner)
        val color_three = findViewById<Spinner>(R.id.fringe_three_spinner)
        val color_tol = findViewById<Spinner>(R.id.tolerance_spinner)

        calculator.setOnClickListener {
            val text_one = color_one.selectedItem.toString()
            val text_two = color_two.selectedItem.toString()
            val text_three = color_three.selectedItem.toString()
            val text_tol = color_tol.selectedItem.toString()


            val resistor = (color_view(text_one)*10 + color_view(text_two))*Math.pow(10.0,color_view(text_three)).toInt()
            val tolerance = tolerance_view(text_tol)
            val info = "Su resistencia es de " + resistor.toString()+"Ω"+ "\n" + "Con un valor de "+ tolerance

            textView.text = info
        }
    }

}