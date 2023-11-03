package com.example.porcisaludvr.GestionCerdos.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.porcisaludvr.GestionCerdos.models.Diagnosticos
import com.example.porcisaludvr.GestionCerdos.room.DiagnosticosDatabaseDao
import com.example.porcisaludvr.GestionCerdos.states.DiagnosticosState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DiagnosticosViewModel(
    private val dao: DiagnosticosDatabaseDao
): ViewModel() {
    var state by mutableStateOf(DiagnosticosState())
        private set
    init {
        viewModelScope.launch{
            dao.obtenerDiagnosticos().collectLatest {
                state = state.copy(
                    listaDiagnosticos = it
                )
            }
        }
    }
    fun agregarDiagnostico(diagnostico: Diagnosticos)=viewModelScope.launch {
        dao.agregarDiagnostico(diagnostico = diagnostico)
    }
    fun actualizarDiagnostico(diagnostico: Diagnosticos)=viewModelScope.launch {
        dao.actualizarDiagnostico(diagnostico = diagnostico)
    }
    fun borrarDiagnostico(diagnostico: Diagnosticos)=viewModelScope.launch {
        dao.borrarDiagnostico(diagnostico = diagnostico)
    }
}