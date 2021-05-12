package com.mf.dres.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mf.dres.data.MuebleDatabase
import com.mf.dres.repository.MuebleRepository
import com.mf.dres.model.Mueble
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MuebleViewModel(application: Application): AndroidViewModel(application) {

    val readAllMuebles: LiveData<List<Mueble>>
    private val repository: MuebleRepository

    init {
        val muebleDao = MuebleDatabase.getDatabase(application).muebleDao()
        repository = MuebleRepository(muebleDao)
        readAllMuebles = repository.readAllMuebles
    }

    fun addMueble(mueble: Mueble) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMueble(mueble)
        }
    }
}