package com.tarea02.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.tarea02.data.SedeDatabase
import com.tarea02.model.Sede
import com.tarea02.repository.SedeRepository
import kotlinx.coroutines.launch
class SedeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SedeRepository
    val getSedes: LiveData<List<Sede>>
    init {
        val sedeDao = SedeDatabase.getDatabase(application).SedeDao()
        repository = SedeRepository(sedeDao)
        getSedes = repository.getSedes
    }
     fun saveSede(sede: Sede) {
        viewModelScope.launch { repository.saveSede(sede) }
    }
    /*
    suspend fun updateLugar(lugar: Lugar) {
        viewModelScope.launch { repository.updateLugar(lugar) }
    }

     */
     fun deleteSede(sede: Sede) {
        viewModelScope.launch { repository.deleteSede(sede) }
    }
}