package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "diagnosticos")
data class Diagnosticos(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("cerdoId")
    val cerdoId: Int,
    @ColumnInfo("estadoId")
    val estadoId: Int,
    @ColumnInfo("fecha")
    val fecha: String,
    @ColumnInfo("sintomas")
    val sintomas: String,
    @ColumnInfo("observaciones")
    val observaciones: String,
)
