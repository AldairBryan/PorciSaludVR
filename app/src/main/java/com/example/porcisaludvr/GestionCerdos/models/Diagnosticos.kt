package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "diagnosticos")
data class Diagnosticos(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    //Cerdo
    //Estado
    @ColumnInfo("fecha")
    val fecha: Date,
    @ColumnInfo("sintomas")
    val sintomas: String,
    @ColumnInfo("observaciones")
    val observaciones: String,
)
