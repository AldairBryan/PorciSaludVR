package com.example.porcisaludvr.GestionCerdos.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.porcisaludvr.GestionCerdos.models.CerdoConEspecie
import com.example.porcisaludvr.GestionCerdos.models.Cerdos
import kotlinx.coroutines.flow.Flow

@Dao
interface CerdosDatabaseDao {
    @Query("SELECT * FROM cerdos")
    fun obtenerCerdos(): Flow<List<CerdoConEspecie>>

    @Query("SELECT * FROM cerdos WHERE id = :id")
    fun obtenerCerdo(id: Int): Flow<Cerdos>

    @Insert
    suspend fun agregarCerdo(cerdo: Cerdos)

    @Update
    suspend fun actualizarCerdo(cerdo: Cerdos)

    @Delete
    suspend fun borrarCerdo(cerdo: Cerdos)
}