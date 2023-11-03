package com.example.porcisaludvr.GestionCerdos.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.porcisaludvr.GestionCerdos.models.Terapias
import com.example.porcisaludvr.GestionCerdos.room.TerapiasDatabaseDao
import com.example.porcisaludvr.GestionCerdos.states.TerapiasState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TerapiasViewModel(
    private val dao: TerapiasDatabaseDao
): ViewModel() {
    var state by mutableStateOf(TerapiasState())
        private set
    init {
        viewModelScope.launch {
            dao.obtenerTerapias().collectLatest {
                state = state.copy(
                    listaTerapias = it
                )
            }
        }
    }
    fun agregarTerapia(terapia: Terapias)=viewModelScope.launch {
        dao.agregarTerapia(terapia=terapia)
    }
    fun actualizarTerapia(terapia: Terapias)=viewModelScope.launch {
        dao.actualizarTerapia(terapia=terapia)
    }
    fun borrarTerapia(terapia: Terapias)=viewModelScope.launch {
        dao.borrarTerapia(terapia=terapia)
    }
}