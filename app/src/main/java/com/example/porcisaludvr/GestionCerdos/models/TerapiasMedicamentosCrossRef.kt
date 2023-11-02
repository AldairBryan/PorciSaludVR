package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.Entity

@Entity(tableName = "terapias_medicamentos_cross_ref", primaryKeys = ["terapiaId", "medicamentoId"])
data class TerapiasMedicamentosCrossRef(
    val terapiaId: Int,
    val medicamentoId: Int
)
