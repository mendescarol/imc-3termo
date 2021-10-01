package br.senai.sp.jandira.imcapp20_a.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import br.senai.sp.jandira.imcapp20_a.R
import br.senai.sp.jandira.imcapp20_a.dao.BiometriaDao
import br.senai.sp.jandira.imcapp20_a.model.Biometria
import kotlinx.android.synthetic.main.activity_biometria.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DadosBiometria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biometria)
        val hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        et_data_pesagem.setText(hoje)

        val btnGravar: Button = findViewById(R.id.bt_gravar)
        val et_peso: EditText = findViewById(R.id.et_peso)
        val spinnerNivelAtividade: Spinner = findViewById(R.id.spinner_nivel_atv)
        val et_data_pesagem: EditText = findViewById(R.id.et_data_pesagem)
        btnGravar.setOnClickListener {
            val biometria = Biometria(
                0,
                et_peso.text.toString().toDouble(),
                spinnerNivelAtividade.toString(),
                et_data_pesagem.text.toString(),
                usuario = 0
            )
            val dao = BiometriaDao(this, biometria)
            dao.gravar()
            Toast.makeText(this, "Dados gravados com sucesso!!", Toast.LENGTH_SHORT).show()

        }
    }
    }