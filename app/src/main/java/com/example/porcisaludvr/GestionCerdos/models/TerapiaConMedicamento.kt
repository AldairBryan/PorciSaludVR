package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TerapiaConMedicamento(
    @Embedded val terapia: Terapias,
    @Relation(
        entity = Medicamentos::class,
        parentColumn = "id",
        entityColumn = "medicamentoId",
        associateBy = Junction(TerapiasMedicamentosCrossRef::class)
    )
    val medicamentos: List<Medicamentos>
)