package com.example.porcisaludvr.GestionCerdos.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.porcisaludvr.GestionCerdos.models.Especies
import kotlinx.coroutines.flow.Flow

interface EspeciesDatabaseDao {
    @Query("SELECT * FROM especies")
    fun obtenerEspecies(): Flow<List<Especies>>

    @Query("SELECT * FROM especies WHERE id = :id")
    fun obtenerEspecie(id: Int): Flow<Especies>

    @Insert
    suspend fun agregarEspecie(especie: Especies)

    @Update
    suspend fun actualizarEspecie(especie: Especies)

    @Delete
    suspend fun borrarEspecie(especie: Especies)
}