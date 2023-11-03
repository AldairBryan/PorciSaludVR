package com.example.porcisaludvr.GestionCerdos.states

import com.example.porcisaludvr.GestionCerdos.models.Diagnosticos

data class DiagnosticosState(
    val listaDiagnosticos: List<Diagnosticos> = emptyList()
)
