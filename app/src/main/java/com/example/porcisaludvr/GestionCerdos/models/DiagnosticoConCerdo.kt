package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.Embedded
import androidx.room.Relation

data class DiagnosticoConCerdo(
    @Embedded val diagnostico: Diagnosticos,
    @Relation(
        parentColumn = "cerdoId",
        entityColumn = "id"
    )
    val cerdo: Cerdos
)

