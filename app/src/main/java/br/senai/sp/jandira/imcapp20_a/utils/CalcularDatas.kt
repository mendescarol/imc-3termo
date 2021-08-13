package br.senai.sp.jandira.imcapp20_a.utils

import android.util.Log
import java.time.LocalDate
import java.time.Period

fun ObterDiferencaEntreDatasEmAnos(dataInicio: String) {
    var hoje : LocalDate = LocalDate.now()

    var ano = dataInicio.substring(0, 3)
    var mes = dataInicio.substring(5, 6).toInt()
    var dia = dataInicio.substring(8, 9).toInt()
    var nascimento = LocalDate.of(2003, 3, 30)

    var idade = Period.between(nascimento, hoje)
    Log.i("XPTO", idade.years.toString())
}