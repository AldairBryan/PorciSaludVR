package com.example.porcisaludvr.GestionCerdos.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.porcisaludvr.GestionCerdos.models.Especies
import com.example.porcisaludvr.GestionCerdos.room.EspeciesDatabaseDao
import com.example.porcisaludvr.GestionCerdos.states.EspeciesState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class EspeciesViewModel (
    private val dao: EspeciesDatabaseDao
): ViewModel(){
    var state by mutableStateOf(EspeciesState())
        private set
    init {
        viewModelScope.launch {
            dao.obtenerEspecies().collectLatest {
                state = state.copy(
                    listaEspecies = it
                )
            }
        }
    }
    fun agregarEspecie(especie: Especies)=viewModelScope.launch {
        dao.agregarEspecie(especie=especie)
    }
    fun actualizarEspecie(especie: Especies)=viewModelScope.launch {
        dao.actualizarEspecie(especie=especie)
    }
    fun borrarEspecie(especie: Especies)=viewModelScope.launch {
        dao.borrarEspecie(especie=especie)
    }
}