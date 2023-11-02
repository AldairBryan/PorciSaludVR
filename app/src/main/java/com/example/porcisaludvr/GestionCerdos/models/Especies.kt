package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "especies")
data class Especies(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("especie")
    val especie: String,
    @ColumnInfo("informacion")
    val informacion: String,
)