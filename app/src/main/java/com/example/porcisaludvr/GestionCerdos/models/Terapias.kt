package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "terapias")
data class Terapias(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("fecha")
    val fecha: Date,
    @ColumnInfo("observaciones")
    val observaciones: String,
    @ColumnInfo("diagnosticoId")
    val diagnosticoId: Int,
)

@Entity(tableName = "terapias_medicamentos_cross_ref", primaryKeys = ["terapiaId", "medicamentoId"])
data class TerapiaMedicamentoCrossRef(
    val terapiaId: Int,
    val medicamentoId: Int
)
