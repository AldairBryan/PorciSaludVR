package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cerdos")
data class Cerdos(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("nombre")
    val nombre: String,
    @ColumnInfo("peso")
    val peso: Double,
    @ColumnInfo("fecha_obtencion")
    val fecha_obtencion: String,
    @ColumnInfo("especieId")
    val especieId: Int,
)
