package com.example.calculadoracomkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var operacao: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_soma.setOnClickListener(this)
        button_divisao.setOnClickListener(this)
        button_multiplicacao.setOnClickListener(this)
        button_subtracao.setOnClickListener(this)

        button_resultado.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.button_soma) {
            operacao = "soma"
        }
        if (v?.id == R.id.button_subtracao) {
            operacao = "subtracao"
        }
        if (v?.id == R.id.button_multiplicacao) {
            operacao = "multiplicacao"
        }
        if (v?.id == R.id.button_divisao) {
            operacao = "divisao"
        }

        if (v?.id == R.id.button_resultado && operacao != null) {
            var num1 = getNumber(text_num1.text.toString())
            var num2 = getNumber(text_num2.text.toString())

            if (num1 == null || num2 == null) {
                text_resultado.text = ("Informe os números a serem calculados")
            } else {
                when (operacao) {
                    "soma" -> text_resultado.text = ("$num1 + $num2 = ${soma(num1,num2).toString()}")
                    "subtracao" -> text_resultado.text = ("$num1 - $num2 = ${subtracao(num1, num2).toString()}")
                    "multiplicacao" -> text_resultado.text = ("$num1 x $num2 = ${multiplicacao(num1, num2).toString()}")
                    "divisao" -> text_resultado.text = ("$num1 / $num2 = ${divisao(num1, num2).toString()}")
                }

                operacao = null
            }
        } else if (v?.id == R.id.button_resultado && operacao == null) {
            text_resultado.text = ("Informe o tipo de operação desejada")
        }
    }

    private fun getNumber(num: String): Float? {
        try {
            return num.toFloat()
        } catch (ex: NumberFormatException) {
            return null
        }
    }

    private fun soma(first: Float, second: Float): Float {
        return first + second
    }

    private fun subtracao(first: Float, second: Float): Float {
        return first - second
    }

    private fun multiplicacao(first: Float, second: Float): Float {
        return first * second
    }

    private fun divisao(first: Float, second: Float): Float {
        return first / second
    }
}