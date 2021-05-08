package com.example.gastodegasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun btclick(view: View) {
        calculate()
    }

    private fun calculate(){
        if(validacaoOk()) {
            try {
                val distancia = findViewById<EditText>(R.id.editDistancia).text.toString().toFloat()
                val autonomia = findViewById<EditText>(R.id.editAutonomia).text.toString().toFloat()
                val preco = findViewById<EditText>(R.id.editPreco).text.toString().toFloat()

                val totalValor = (distancia * preco) / autonomia
                textTotalValor.text = "R$ ${"%.2f".format(totalValor)}"

            } catch (nfe: NumberFormatException){
                Toast.makeText(this, getString(R.string.informe_valores_validos) , Toast.LENGTH_LONG).show()
            }

        }else{
            Toast.makeText(this, getString(R.string.preencha_os_campos) , Toast.LENGTH_LONG).show()
        }

    }

    private fun validacaoOk(): Boolean {
        return (editDistancia.text.toString() != "" && editAutonomia.text.toString() != ""
                && editPreco.text.toString() != "")

    }
}

