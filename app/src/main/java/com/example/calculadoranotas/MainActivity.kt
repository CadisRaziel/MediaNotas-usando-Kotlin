package com.example.calculadoranotas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoranotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCalcular.setOnClickListener {
            val num1 = binding.nota1
            val num2 = binding.nota2
            val num3 = binding.nota3
            val num4 = binding.nota4
            val faltas = binding.faltas
            val resultado = binding.txtResultado

            //convertendo o texto da caixa "info nota" que no caso sao os numeros que sao recebidos como texto para numeros inteiros
            val nota1 = Integer.parseInt(num1.text.toString())
            val nota2 = Integer.parseInt(num2.text.toString())
            val nota3 = Integer.parseInt(num3.text.toString())
            val nota4 = Integer.parseInt(num4.text.toString())
            val numeroFaltas = Integer.parseInt(faltas.text.toString())

            //depois de converter para numeros inteiros eu começo a fazer os calculos
            val media = (nota1 + nota2 + nota3 + nota4) / 4

            if(media >= 5 && numeroFaltas <= 20){
                resultado.setText("Aluno foi aprovado \n Média final $media")
                resultado.setTextColor(getColor(R.color.green))
            } else if (numeroFaltas > 20){
                resultado.setText("Aluno reprovado por faltas, execedeu mais do que 20 faltas \n Média final $media")
                resultado.setTextColor(getColor(R.color.red))
            } else if (media < 5){
                resultado.setText("Aluno foi reprovado por nota \n Média final $media")
                resultado.setTextColor(getColor(R.color.red))
            }

        }
    }
}