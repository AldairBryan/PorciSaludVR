package com.example.porcisaludvr.GestionCerdos.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.porcisaludvr.GestionCerdos.models.Cerdos
import com.example.porcisaludvr.GestionCerdos.room.CerdosDatabaseDao
import com.example.porcisaludvr.GestionCerdos.states.CerdosState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CerdosViewModel(
    private val dao: CerdosDatabaseDao
): ViewModel() {
    var state by mutableStateOf(CerdosState())
        private set
    init {
        viewModelScope.launch {
            dao.obtenerCerdos().collectLatest {
                state = state.copy(
                    listaCerdos = it
                )
            }
        }
    }
    fun agregarCerdo(cerdo: Cerdos)=viewModelScope.launch {
        dao.agregarCerdo(cerdo=cerdo)
    }
    fun actualizarCerdo(cerdo: Cerdos)=viewModelScope.launch {
        dao.actualizarCerdo(cerdo = cerdo)
    }
    fun borrarCerdo(cerdo: Cerdos)=viewModelScope.launch {
        dao.borrarCerdo(cerdo = cerdo)
    }
}