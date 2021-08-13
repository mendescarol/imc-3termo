package br.senai.sp.jandira.imcapp20_a.dao

import android.content.ContentValues
import android.content.Context
import android.util.Log
import br.senai.sp.jandira.imcapp20_a.model.Usuario

class UsuarioDao(val context: Context, val usuario: Usuario?) {

    val dbHelper = ImcDataBase.getDatabase(context)

    public fun gravar() {

        // *** obter uma instância do banco para escrita
        val db = dbHelper.writableDatabase

        // *** Criar os valores que serão inseridos no banco
        val dados = ContentValues()
        dados.put("nome", usuario!!.nome)
        dados.put("profissao", usuario.profissao)
        dados.put("email", usuario.email)
        dados.put("senha", usuario.senha)
        dados.put("altura", usuario.altura)
        dados.put("data_nascimento", usuario.dataNascimento.toString())
        dados.put("sexo", usuario.sexo.toString())

        // *** Executar o comando de gravação
        db.insert("tb_usuario", null, dados)

        db.close()
    }

    fun autenticar(email: String, senha: String) {
        //** Obter uma instancia de leitura do banco
        val db = dbHelper.readableDatabase

        //determinar quais são as colunas da tabela
        //** que nós queremos no resultado
        //**criar uma projeção
        val campos = arrayOf(
            "email",
            "senha",
            "nome",
            "profissao",
            "data_nascimento")

        // ** Vamos definir o filtro da consulta
        // *** O que estamos fazendo é contruir o filtro
        //*** WHERE EMAIL = ? AND senha = ?"
        val filtro = "email = ? AND senha= ?"

        //*** vaos criar agora o argumento do filtro
        //*** vamos dizer ao Kotlin quais serão os valores
        //***que deverão ser sunstituidos pelas "?" no filtro

        val argumentos = arrayOf(email, senha)

        //*** executar a consulta  e obter o resultado em um "cursor"

        val cursor = db.query(
        "tb_usuario",
        campos,
        filtro,
        argumentos,
        null,
        null,
        null

        )

       Log.i("XPTO", "Linhas ${cursor.count.toString()}")

    }

}