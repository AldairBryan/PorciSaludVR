package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.Embedded
import androidx.room.Relation

data class CerdoConEspecie(
    @Embedded val cerdo: Cerdos,
    @Relation(
        parentColumn = "especieId",
        entityColumn = "id"
    )
    val especie: Especies
)
