package com.example.porcisaludvr.GestionCerdos.states

import com.example.porcisaludvr.GestionCerdos.models.Estados

data class EstadosState(
    val listaEstados: List<Estados> = emptyList()
)
