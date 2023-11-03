package com.example.porcisaludvr.GestionCerdos.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.porcisaludvr.GestionCerdos.models.TerapiasMedicamentosCrossRef
import com.example.porcisaludvr.GestionCerdos.room.TerMedCrossDatabaseDao
import com.example.porcisaludvr.GestionCerdos.states.TerMedCrossRefState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TerMedCrossRefViewModel(
    private val dao: TerMedCrossDatabaseDao
): ViewModel() {
    var state by mutableStateOf(TerMedCrossRefState())
        private set
    init {
        viewModelScope.launch {
            dao.obtenerAllTerMedCross().collectLatest {
                state = state.copy(
                    listaTerMedCrossRef = it
                )
            }
        }
    }
    fun agregarTerMedCrossRef(terMedCrossRef: TerapiasMedicamentosCrossRef)=viewModelScope.launch {
        dao.agregarTerMedCross(terapiaMedicamento = terMedCrossRef)
    }
    fun actualizarTerMedCrossRef(terMedCrossRef: TerapiasMedicamentosCrossRef)=viewModelScope.launch {
        dao.actualizarTerMedCross(terapiaMedicamento = terMedCrossRef)
    }
    fun borrarTerMedCrossRef(terMedCrossRef: TerapiasMedicamentosCrossRef)=viewModelScope.launch {
        dao.borrarTerMedCross(terapiaMedicamento = terMedCrossRef)
    }
}