package com.challenge.postman.common.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.challenge.postman.tareas.domain.TareasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    application: Application,
    private val tareasRepository: TareasRepository
): AndroidViewModel(application) {

}