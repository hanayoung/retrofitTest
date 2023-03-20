package com.aoreo.httpcommunicationtest.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aoreo.httpcommunicationtest.api.PlantApi
import com.aoreo.httpcommunicationtest.api.RetrofitInstance
import com.aoreo.httpcommunicationtest.model.Plant
import com.aoreo.httpcommunicationtest.repository.Repository
import kotlinx.coroutines.launch

class PlantViewModel : ViewModel() {

//    private val retrofitInstance : PlantApi = RetrofitInstance.getInstance().create(PlantApi::class.java)
    private val repository = Repository()

    private val TAG = PlantViewModel::class.java

    private val _result = MutableLiveData<List<Plant>>()
    val result : LiveData<List<Plant>>
    get()= _result

    fun getAllPlants() = viewModelScope.launch {
        Log.d(TAG.toString(), repository.getAllData().toString())
        _result.value=repository.getAllData()
    }
}