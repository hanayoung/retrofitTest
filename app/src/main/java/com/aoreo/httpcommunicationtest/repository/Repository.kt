package com.aoreo.httpcommunicationtest.repository

import com.aoreo.httpcommunicationtest.api.PlantApi
import com.aoreo.httpcommunicationtest.api.RetrofitInstance

class Repository {
    private val client = RetrofitInstance.getInstance().create(PlantApi::class.java)

    suspend fun getAllData() = client.getAllPlants()
}