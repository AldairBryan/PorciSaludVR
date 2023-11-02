package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicamentos")
data class Medicamentos(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("medicamento")
    val medicamento: String,
    @ColumnInfo("precio")
    val precio: Double,
    @ColumnInfo("descripcion")
    val descripcion: String ,
)
