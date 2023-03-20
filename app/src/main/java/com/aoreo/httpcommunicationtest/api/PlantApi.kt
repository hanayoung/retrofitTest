package com.aoreo.httpcommunicationtest.api

import com.aoreo.httpcommunicationtest.model.Plant
import retrofit2.http.GET

interface PlantApi {

    @GET("https://raw.githubusercontent.com/googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants() : List<Plant>
}