package com.example.porcisaludvr.GestionCerdos.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.porcisaludvr.GestionCerdos.models.Cerdos
import com.example.porcisaludvr.GestionCerdos.models.Diagnosticos
import com.example.porcisaludvr.GestionCerdos.models.Especies
import com.example.porcisaludvr.GestionCerdos.models.Estados
import com.example.porcisaludvr.GestionCerdos.models.Medicamentos
import com.example.porcisaludvr.GestionCerdos.models.Terapias
import com.example.porcisaludvr.GestionCerdos.models.TerapiasMedicamentosCrossRef

@Database(
    entities = [Especies::class, Estados::class, Medicamentos::class, Cerdos::class, Terapias::class, Diagnosticos::class, TerapiasMedicamentosCrossRef::class],
    version = 1,
    exportSchema = false
)
abstract class GestionDatabase:RoomDatabase() {
}