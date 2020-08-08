package com.example.dogs.models

import com.example.dogs.models.DogBreed
import io.reactivex.Single
import retrofit2.http.GET

interface DogsApi {
    @GET("/DevTides/DogsApi/master/dogs.json")
    fun getDogs(): Single<List<DogBreed>>
}