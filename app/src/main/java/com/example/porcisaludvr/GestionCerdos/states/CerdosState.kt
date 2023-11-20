package com.example.porcisaludvr.GestionCerdos.states

import com.example.porcisaludvr.GestionCerdos.models.CerdoConEspecie

data class CerdosState(
    val listaCerdos: List<CerdoConEspecie> = emptyList()
)
