package com.example.porcisaludvr.GestionCerdos.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.porcisaludvr.GestionCerdos.models.Medicamentos
import kotlinx.coroutines.flow.Flow

interface MedicamentosDatabaseDao {
    @Query("SELECT * FROM medicamentos")
    fun obtenerMedicamentos(): Flow<List<Medicamentos>>

    @Query("SELECT * FROM medicamentos WHERE id = :id")
    fun obtenerMedicamento(id: Int): Flow<Medicamentos>

    @Insert
    suspend fun agregarMedicamento(medicamento: Medicamentos)

    @Update
    suspend fun actualizarMedicamento(medicamento: Medicamentos)

    @Delete
    suspend fun borrarMedicamento(medicamento: Medicamentos)
}