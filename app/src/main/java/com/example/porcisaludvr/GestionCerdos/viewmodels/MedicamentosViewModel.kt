package com.example.porcisaludvr.GestionCerdos.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.porcisaludvr.GestionCerdos.models.Medicamentos
import com.example.porcisaludvr.GestionCerdos.room.MedicamentosDatabaseDao
import com.example.porcisaludvr.GestionCerdos.states.MedicamentosState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MedicamentosViewModel(
    private val dao: MedicamentosDatabaseDao
): ViewModel(){
    var state by mutableStateOf(MedicamentosState())
        private set
    init {
        viewModelScope.launch {
            dao.obtenerMedicamentos().collectLatest {
                state = state.copy(
                    listaMedicamentos = it
                )
            }
        }
    }
    fun agregarMedicamento(medicamento: Medicamentos)=viewModelScope.launch {
        dao.agregarMedicamento(medicamento=medicamento)
    }
    fun actualizarMedicamento(medicamento: Medicamentos)=viewModelScope.launch {
        dao.actualizarMedicamento(medicamento=medicamento)
    }
    fun borrarMedicamento(medicamento: Medicamentos)=viewModelScope.launch {
        dao.borrarMedicamento(medicamento=medicamento)
    }
}