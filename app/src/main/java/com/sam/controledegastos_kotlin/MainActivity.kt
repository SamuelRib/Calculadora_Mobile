package com.sam.controledegastos_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.sam.controledegastos_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var resultado = binding.txtResultado
        val campoDados = binding.campoDados
        val entrada = binding.btMais
        val saida = binding.btMenos

        entrada.setOnClickListener {

            var dados = campoDados.text.toString()
            var resultadoInicial = resultado.text.toString()

            if (dados.isEmpty()){

                Snackbar.make(it,"Preencha o campo vazio!",Snackbar.LENGTH_SHORT).show()
            } else{
            calcularDadosSoma()
            }
        }

        saida.setOnClickListener {
            var dados = campoDados.text.toString()
            var resultadoInicial = resultado.text.toString()

            if (dados.isEmpty()){

                Snackbar.make(it,"Preencha o campo vazio!",Snackbar.LENGTH_SHORT).show()
            } else{
                calcularDadosSubtracao()
            }
        }
    }


    fun calcularDadosSoma(){

       val resultado = binding.txtResultado
        val campoDados = binding.campoDados
        val resultado2 = java.lang.Float.parseFloat(resultado.text.toString())
        val campoDados2 = java.lang.Float.parseFloat(campoDados.text.toString())

        val calculo = resultado2 + campoDados2
        val exibirResultado = resultado.setText(calculo.toString())
        val apagarCampoDados = campoDados.setText("").toString()
    }

    fun calcularDadosSubtracao(){

        val resultado = binding.txtResultado
        val campoDados = binding.campoDados
        //val resultado2 = Integer.parseInt(resultado.text.toString())
        val resultado2 = java.lang.Float.parseFloat(resultado.text.toString())
        //val campoDados2 = Integer.parseInt(campoDados.text.toString())
        val campoDados2 = java.lang.Float.parseFloat(campoDados.text.toString())

        val calculo = resultado2 - campoDados2
        val exibirResultado = resultado.setText(calculo.toString())
        val apagarCampoDados = campoDados.setText("").toString()
    }
}