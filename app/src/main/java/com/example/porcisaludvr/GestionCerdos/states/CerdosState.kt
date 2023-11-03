package com.example.porcisaludvr.GestionCerdos.states

import com.example.porcisaludvr.GestionCerdos.models.Cerdos

data class CerdosState(
    val listaCerdos: List<Cerdos> = emptyList()
)
