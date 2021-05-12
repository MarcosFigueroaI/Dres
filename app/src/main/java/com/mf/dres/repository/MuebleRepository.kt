package com.mf.dres.repository

import androidx.lifecycle.LiveData
import com.mf.dres.data.MuebleDao
import com.mf.dres.model.Mueble

class MuebleRepository(private val muebleDao: MuebleDao) {

    val readAllMuebles: LiveData<List<Mueble>> = muebleDao.readAllMuebles()

    suspend fun addMueble(mueble: Mueble) {
        muebleDao.addMueble(mueble)
    }
}