package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.Embedded
import androidx.room.Relation

data class DiagnosticoConTerapias(
    @Embedded val diagnostico: Diagnosticos,
    @Relation(
        parentColumn = "id",
        entityColumn = "diagnosticoId"
    )
    val terapias: List<Terapias>
)
