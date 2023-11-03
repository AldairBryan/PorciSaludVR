package com.example.porcisaludvr.GestionCerdos.states

import com.example.porcisaludvr.GestionCerdos.models.Especies

data class EspeciesState(
    val listaEspecies: List<Especies> = emptyList()
)
