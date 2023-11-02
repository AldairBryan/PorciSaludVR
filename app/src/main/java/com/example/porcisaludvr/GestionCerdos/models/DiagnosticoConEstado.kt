package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.Embedded
import androidx.room.Relation

data class DiagnosticoConEstado(
    @Embedded val diagnostico: Diagnosticos,
    @Relation(
        parentColumn = "estadoId",
        entityColumn = "id"
    )
    val estado: Estados
)
