package com.tarea02.repository

import androidx.lifecycle.LiveData
import com.tarea02.data.SedeDao
import com.tarea02.model.Sede
class SedeRepository(private val sedeDao: SedeDao) {
    suspend fun saveSede(sede: Sede) {
        if (sede.id == 0){
            sedeDao.addSede(sede)
        }else {
            sedeDao.updateSede(sede)
        }
        sedeDao.addSede(sede)
    }
    suspend fun updateSede(sede: Sede) {
        sedeDao.updateSede(sede)
    }
    suspend fun deleteSede(sede: Sede) {
        sedeDao.deleteSede(sede)
    }
    val getSedes : LiveData<List<Sede>> = sedeDao.getSedes()
}