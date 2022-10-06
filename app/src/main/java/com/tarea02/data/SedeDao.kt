package com.tarea02.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.tarea02.model.Sede
@Dao
interface SedeDao {
    //CRUD  = Create Read Update Delete

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSede(sede: Sede)
    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateSede(sede: Sede)
    @Delete
    suspend fun deleteSede(sede: Sede)

    @Query ("SELECT * FROM Sede")
    fun getSedes() : LiveData<List<Sede>>
}