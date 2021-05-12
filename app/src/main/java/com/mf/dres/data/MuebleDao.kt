package com.mf.dres.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mf.dres.model.Mueble

@Dao
interface MuebleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMueble(mueble: Mueble)

    @Query("select * from muebles order by id asc")
    fun readAllMuebles(): LiveData<List<Mueble>>
}