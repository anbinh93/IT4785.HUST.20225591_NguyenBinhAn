package com.anbinh.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private val ADDITION = '+'
    private val SUBTRACTION = '-'
    private val MULTIPLICATION = '*'
    private val DIVISION = '/'
    private val PERCENT = '%'

    private var currentSymbol: Char = '0'
    private var firstValue = Double.NaN
    private var secondValue: Double = 0.0
    private lateinit var inputDisplay: TextView
    private lateinit var outputDisplay: TextView
    private lateinit var decimalFormat: DecimalFormat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decimalFormat = DecimalFormat("#.##########")

        inputDisplay = findViewById(R.id.input)
        outputDisplay = findViewById(R.id.output)

        val button0: MaterialButton = findViewById(R.id.btn0)
        val button1: MaterialButton = findViewById(R.id.btn1)
        val button2: MaterialButton = findViewById(R.id.btn2)
        val button3: MaterialButton = findViewById(R.id.btn3)
        val button4: MaterialButton = findViewById(R.id.btn4)
        val button5: MaterialButton = findViewById(R.id.btn5)
        val button6: MaterialButton = findViewById(R.id.btn6)
        val button7: MaterialButton = findViewById(R.id.btn7)
        val button8: MaterialButton = findViewById(R.id.btn8)
        val button9: MaterialButton = findViewById(R.id.btn9)

        val buttonAdd: MaterialButton = findViewById(R.id.add)
        val buttonSub: MaterialButton = findViewById(R.id.subtract)
        val buttonMultiply: MaterialButton = findViewById(R.id.multiply)
        val buttonDivide: MaterialButton = findViewById(R.id.division)
        val buttonPercent: MaterialButton = findViewById(R.id.percent)
        val buttonDot: MaterialButton = findViewById(R.id.btnPoint)
        val buttonClear: MaterialButton = findViewById(R.id.clear)
        val buttonOFF: MaterialButton = findViewById(R.id.off)
        val buttonEqual: MaterialButton = findViewById(R.id.equal)
        val buttonPlusMinus: MaterialButton = findViewById(R.id.btnPlusMinus)

        button0.setOnClickListener { inputDisplay.append("0") }
        button1.setOnClickListener { inputDisplay.append("1") }
        button2.setOnClickListener { inputDisplay.append("2") }
        button3.setOnClickListener { inputDisplay.append("3") }
        button4.setOnClickListener { inputDisplay.append("4") }
        button5.setOnClickListener { inputDisplay.append("5") }
        button6.setOnClickListener { inputDisplay.append("6") }
        button7.setOnClickListener { inputDisplay.append("7") }
        button8.setOnClickListener { inputDisplay.append("8") }
        button9.setOnClickListener { inputDisplay.append("9") }

        buttonAdd.setOnClickListener {
            allCalculations()
            currentSymbol = ADDITION
            outputDisplay.text = "${decimalFormat.format(firstValue)}+"
            inputDisplay.text = null
        }

        buttonSub.setOnClickListener {
            allCalculations()
            currentSymbol = SUBTRACTION
            outputDisplay.text = "${decimalFormat.format(firstValue)}-"
            inputDisplay.text = null
        }

        buttonMultiply.setOnClickListener {
            allCalculations()
            currentSymbol = MULTIPLICATION
            outputDisplay.text = "${decimalFormat.format(firstValue)}x"
            inputDisplay.text = null
        }

        buttonDivide.setOnClickListener {
            allCalculations()
            currentSymbol = DIVISION
            outputDisplay.text = "${decimalFormat.format(firstValue)}/"
            inputDisplay.text = null
        }

        buttonPercent.setOnClickListener {
            allCalculations()
            currentSymbol = PERCENT
            outputDisplay.text = "${decimalFormat.format(firstValue)}%"
            inputDisplay.text = null
        }

        buttonDot.setOnClickListener { inputDisplay.append(".") }

        buttonClear.setOnClickListener {
            if (inputDisplay.text.isNotEmpty()) {
                inputDisplay.text = inputDisplay.text.dropLast(1)
            } else {
                firstValue = Double.NaN
                secondValue = Double.NaN
                inputDisplay.text = ""
                outputDisplay.text = ""
            }
        }

        buttonOFF.setOnClickListener { finish() }

        buttonEqual.setOnClickListener {
            allCalculations()
            outputDisplay.text = decimalFormat.format(firstValue)
            firstValue = Double.NaN
            currentSymbol = '0'
        }
        buttonPlusMinus.setOnClickListener {
            if (inputDisplay.text.isNotEmpty()) {
                val value = inputDisplay.text.toString().toDouble()
                inputDisplay.text = if (value > 0) "-$value" else "${-value}"
            }
        }
    }

    private fun allCalculations() {
        if (!firstValue.isNaN()) {
            secondValue = inputDisplay.text.toString().toDouble()
            inputDisplay.text = null

            firstValue = when (currentSymbol) {
                ADDITION -> firstValue + secondValue
                SUBTRACTION -> firstValue - secondValue
                MULTIPLICATION -> firstValue * secondValue
                DIVISION -> firstValue / secondValue
                PERCENT -> firstValue % secondValue
                else -> firstValue
            }
        } else {
            try {
                firstValue = inputDisplay.text.toString().toDouble()
            } catch (_: Exception) {
            }
        }
    }
}