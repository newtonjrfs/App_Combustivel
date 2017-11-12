package newton.com.alcoolougasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view : View){

        //val precoAlcool = findViewById<EditText>(R.id.edit_preco_alcool)
        //val precoGasolina = findViewById<EditText>(R.id.edit_preco_gasolina)

        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()
        val validaCampos = validarCampos(precoAlcool,precoGasolina)

        if (validaCampos == true){
            CalcularMelhorPreco(precoAlcool,precoGasolina)
        }else{
            text_resultado.setText("Preencha os preços primeiro")
        }


    }

    fun validarCampos(alcool : String,gasolina : String) : Boolean{

        var camposValidados: Boolean = true

        if (alcool == null || alcool.equals("")){
            camposValidados = false
        }else if (gasolina == null || gasolina.equals("")){
            camposValidados = false
        }

        return camposValidados

    }

    fun CalcularMelhorPreco(alcool : String,gasolina : String){

        val valorAlcool = alcool.toDouble()
        val valorGasolina = gasolina.toDouble()

        val resultado = valorAlcool/valorGasolina

        if (resultado >= 0.7){
            text_resultado.setText("É melhor utilizar gasolina")
        }else{
            text_resultado.setText("É melhor utilizar alcool")
        }

    }

}
