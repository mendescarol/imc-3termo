package br.senai.sp.jandira.imcapp20_a.ui
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import br.senai.sp.jandira.imcapp20_a.R
import br.senai.sp.jandira.imcapp20_a.utils.converterBase64ParaBitmap
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_dash_board.*
class DashBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        val alertDialog = android.app.AlertDialog.Builder(this)
        alertDialog.setTitle("Cadastro não finalizado!")
        alertDialog.setMessage("O seu cadastro ainda não foi finalizado. Deseja conclui-lo agora?")
        alertDialog.setPositiveButton("Sim") { dialogInterface: DialogInterface, i: Int ->
            abrirTelaBiometria()
        }
        alertDialog.setNegativeButton("Não") { dialogInterface: DialogInterface, i: Int ->


        }
        alertDialog.show()



        preencherDashBoard()
        tv_logout.setOnClickListener {
            val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
            val editor = dados.edit()
            editor.putBoolean("lembrar", false)
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun preencherDashBoard() {
        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
        tv_profile_name.text = dados.getString("nome", "")
        tv_profile_occupation.text = dados.getString("profissao", "")
        tv_weight.text = dados.getInt("peso", 0).toString()
        tv_age.text = dados.getString("idade", "")
        val imagemBase64 = dados.getString("foto", "")
        val imagemBitmap = converterBase64ParaBitmap(imagemBase64)
        iv_profile.setImageBitmap(imagemBitmap)


    }
    private fun abrirTelaBiometria() {
        val intent = Intent(this, DadosBiometria::class.java)
        startActivity(intent)
        finish()
    }


}





