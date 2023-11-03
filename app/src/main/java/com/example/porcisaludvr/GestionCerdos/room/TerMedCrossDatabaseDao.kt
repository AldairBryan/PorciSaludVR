package com.example.porcisaludvr.GestionCerdos.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.porcisaludvr.GestionCerdos.models.TerapiasMedicamentosCrossRef
import kotlinx.coroutines.flow.Flow
@Dao
interface TerMedCrossDatabaseDao {
    @Query("SELECT * FROM terapias_medicamentos_cross_ref")
    fun obtenerAllTerMedCross(): Flow<List<TerapiasMedicamentosCrossRef>>

    @Query("SELECT * FROM terapias_medicamentos_cross_ref WHERE terapiaId = :idTerapia")
    fun obtenerTerMedCross(idTerapia: Int): Flow<TerapiasMedicamentosCrossRef>

    @Insert
    suspend fun agregarTerMedCross(terapiaMedicamento: TerapiasMedicamentosCrossRef)

    @Update
    suspend fun actualizarTerMedCross(terapiaMedicamento: TerapiasMedicamentosCrossRef)

    @Delete
    suspend fun borrarTerMedCross(terapiaMedicamento: TerapiasMedicamentosCrossRef)
}