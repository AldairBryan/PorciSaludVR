package com.example.porcisaludvr.GestionCerdos.states

import com.example.porcisaludvr.GestionCerdos.models.TerapiasMedicamentosCrossRef

data class TerMedCrossRefState(
    val listaTerMedCrossRef: List<TerapiasMedicamentosCrossRef> = emptyList()
)
