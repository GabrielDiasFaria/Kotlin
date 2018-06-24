package com.mytrip.gdfconsultoria.mytrip

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(view: View) {
        val id = view.id

        if (id == R.id.buttonCalcular){
            handleCalculate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular.setOnClickListener(this)
    }

    private fun handleCalculate(){
        if (isValid()){
            try {

                var distancia = editDistancia.text.toString().toFloat()
                var preco = editPreco.text.toString().toFloat()
                var autonimia = editAutonomia.text.toString().toFloat()

                var result = (distancia * preco) / autonimia

                textResultado.setText("Total: R$ $result")

            } catch (nfe: NumberFormatException){
                Toast.makeText(this, getString(R.string.valores_validos), Toast.LENGTH_LONG).show()
            }
        } else{
            Toast.makeText(this, getString(R.string.valores_validos), Toast.LENGTH_LONG).show()
        }
    }

    private fun isValid(): Boolean{
        return editDistancia.text.toString() != ""
            && editPreco.text.toString() != ""
            && editAutonomia.text.toString() != ""
            && editAutonomia.text.toString() != "0"
    }

}
