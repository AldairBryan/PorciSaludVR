package com.example.porcisaludvr.GestionCerdos.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.porcisaludvr.GestionCerdos.models.Estados
import kotlinx.coroutines.flow.Flow

interface EstadosDatabaseDao {
    @Query("SELECT * FROM estados")
    fun obtenerEstados(): Flow<List<Estados>>

    @Query("SELECT * FROM estados WHERE id = :id")
    fun obtenerEstado(id: Int): Flow<Estados>

    @Insert
    suspend fun agregarEstado(estado: Estados)

    @Update
    suspend fun actualizarEstado(estado: Estados)

    @Delete
    suspend fun borrarEstado(estado: Estados)
}