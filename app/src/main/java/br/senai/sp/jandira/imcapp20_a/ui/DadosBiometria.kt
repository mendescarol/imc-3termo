package br.senai.sp.jandira.imcapp20_a.ui

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import br.senai.sp.jandira.imcapp20_a.R
import kotlinx.android.synthetic.main.activity_biometria.*
import kotlinx.android.synthetic.main.activity_novo_usuario.*
import java.util.*


class DadosBiometria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biometria)

        val btnGravar: Button = findViewById(R.id.bt_gravar)
        val etPeso: EditText = findViewById(R.id.et_peso)
        val spinnerNivelAtividade: Spinner = findViewById(R.id.spinner_nivel_atv)
        val et_data_Pesagem: EditText = findViewById(R.id.et_data_pesagem)

        //criar um calendário
        val calendario = Calendar.getInstance()
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        //Abrir um componente DatePickerDialog
        et_data_pesagem.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, _ano, _mes, _dia ->
                var diaZero = "$_dia"
                var mesZero = "$_mes"

                if(_dia < 10){
                    diaZero = "0$_dia"
                }

                if(_mes < 10){
                    mesZero = "0${_mes + 1}"
                }

                et_data_pesagem.setText("$diaZero/$mesZero/$_ano")
            }, ano, mes, dia)
            dpd.show()
        }

    }

}
