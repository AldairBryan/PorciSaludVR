package com.example.porcisaludvr.GestionCerdos.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.porcisaludvr.GestionCerdos.models.Estados
import com.example.porcisaludvr.GestionCerdos.room.EstadosDatabaseDao
import com.example.porcisaludvr.GestionCerdos.states.EstadosState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class EstadosViewModel(
    private val dao: EstadosDatabaseDao
): ViewModel() {
    var state by mutableStateOf(EstadosState())
        private set
    init {
        viewModelScope.launch{
            dao.obtenerEstados().collectLatest {
                state=state.copy(
                    listaEstados = it
                )
            }
        }
    }
    fun agregarEstado(estado: Estados)=viewModelScope.launch {
        dao.agregarEstado(estado=estado)
    }
    fun actualizarEstado(estado: Estados)=viewModelScope.launch {
        dao.actualizarEstado(estado=estado)
    }
    fun borrarEstado(estado: Estados)=viewModelScope.launch {
        dao.borrarEstado(estado=estado)
    }
}