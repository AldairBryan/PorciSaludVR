package com.example.porcisaludvr.GestionCerdos.states

import com.example.porcisaludvr.GestionCerdos.models.Terapias

data class TerapiasState(
    val listaTerapias: List<Terapias> = emptyList()
)
