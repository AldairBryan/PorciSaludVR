package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.Embedded
import androidx.room.Relation

data class TerapiaConMedicamento(
    @Embedded val terapia: Terapias,
    @Relation(
        parentColumn = "medicamentoId",
        entityColumn = "id"
    )
    val medicamento: Medicamentos
)

