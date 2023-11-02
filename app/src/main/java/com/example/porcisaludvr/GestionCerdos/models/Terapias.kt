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

