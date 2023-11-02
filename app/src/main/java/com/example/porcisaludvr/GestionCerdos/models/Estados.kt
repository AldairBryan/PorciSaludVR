package com.example.porcisaludvr.GestionCerdos.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estados")
data class Estados(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("estado")
    val estado: String,
)
