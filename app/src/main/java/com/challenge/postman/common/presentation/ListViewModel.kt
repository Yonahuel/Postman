package com.challenge.postman.common.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.challenge.postman.tareas.data.entities.Tarea
import com.challenge.postman.tareas.domain.TareasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    application: Application,
    private val tareasRepository: TareasRepository
): AndroidViewModel(application) {
    val allTareas: LiveData<List<Tarea>> = tareasRepository.allTareas
    private val _tareaSeleccionada = MutableLiveData<Tarea>()
    val tareaSeleccionada: LiveData<Tarea> = _tareaSeleccionada

    fun insertTarea(tarea: Tarea) = viewModelScope.launch(Dispatchers.IO) {
        tareasRepository.insertTarea(tarea)
    }

    fun updateTarea(tarea: Tarea) = viewModelScope.launch(Dispatchers.IO) {
        tareasRepository.updateTarea(tarea)
    }

    fun deleteTarea(tarea: Tarea) = viewModelScope.launch(Dispatchers.IO) {
        tareasRepository.deleteTarea(tarea)
    }

    fun seleccionarTarea(tarea: Tarea) {
        _tareaSeleccionada.value = tarea
    }
}