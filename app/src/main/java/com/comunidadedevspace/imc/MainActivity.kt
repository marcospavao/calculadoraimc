package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recuperar os componentes EditText
        //criar uma variavel e associar o componente de UI<EditText>
        // recuperar o botao da tela
        // colocar açao no botaoc
        // recuperar o texto digitado no edt peso
        //Sobre o float e o toString abaixo Em resumo, este código pega os valores de entrada dos campos de texto, que são strings,
        // e os converte para valores de ponto flutuante para que possam ser utilizados em cálculos
        // numéricos posteriores. Isso é útil em muitas aplicações, como calcular o índice de massa
        // corporal (IMC) ou outras operações que requerem manipulação numérica precisa.


        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)


        btnCalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String  = edtAltura.text.toString()

           if (pesoStr == "" || alturaStr == ""){
           //mostrar mensagem pra o usuario
            Snackbar.make(
                edtPeso,
                    "preencha todos os campos",
                    Snackbar.LENGTH_LONG

            )
                .show()

           } else {

               val peso = pesoStr.toFloat()
               val altura = alturaStr.toFloat()

               val alturaQ2 = altura * altura
               val resultado = peso / alturaQ2

              //navegar para a proxiima tela
               //criar o layout da proxima tela
               //passar dados (resultado) para proxima tela

               // intent - classe do proprio android
               val intent = Intent (this, ResultActivity::class.java)
              intent.putExtra(KEY_RESULT_IMC, resultado)
              startActivity(intent)


               println("ação botão peso = " + resultado)
           }
        }
    }
}