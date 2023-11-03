package com.example.porcisaludvr.GestionCerdos.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.porcisaludvr.GestionCerdos.models.Terapias
import kotlinx.coroutines.flow.Flow

interface TerapiasDatabaseDao {
    @Query("SELECT * FROM terapias")
    fun obtenerTerapias(): Flow<List<Terapias>>

    @Query("SELECT * FROM terapias WHERE id = :id")
    fun obtenerTerapia(id: Int): Flow<Terapias>

    @Insert
    suspend fun agregarTerapia(terapia: Terapias)

    @Update
    suspend fun actualizarTerapia(terapia: Terapias)

    @Delete
    suspend fun borrarTerapia(terapia: Terapias)
}