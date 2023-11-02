package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.Embedded
import androidx.room.Relation

data class TerapiaConDiagnostico(
    @Embedded val terapia: Terapias,
    @Relation(
        parentColumn = "diagnosticoId",
        entityColumn = "id"
    )
    val diagnostico: Diagnosticos
)
