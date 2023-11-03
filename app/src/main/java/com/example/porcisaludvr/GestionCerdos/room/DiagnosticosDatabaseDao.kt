package com.example.porcisaludvr.GestionCerdos.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.porcisaludvr.GestionCerdos.models.Diagnosticos
import kotlinx.coroutines.flow.Flow

interface DiagnosticosDatabaseDao {
    @Query("SELECT * FROM diagnosticos")
    fun obtenerDiagnosticos(): Flow<List<Diagnosticos>>

    @Query("SELECT * FROM diagnosticos WHERE id = :id")
    fun obtenerDiagnostico(id: Int): Flow<Diagnosticos>

    @Insert
    suspend fun agregarDiagnostico(diagnostico: Diagnosticos)

    @Update
    suspend fun actualizarDiagnostico(diagnostico: Diagnosticos)

    @Delete
    suspend fun borrarDiagnostico(diagnostico: Diagnosticos)
}