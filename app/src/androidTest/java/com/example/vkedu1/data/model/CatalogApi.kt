package com.example.vkedu1.data.remote

import com.example.vkedu1.data.model.AppDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CatalogApi {

    // Получение всего каталога
    @GET("catalog")
    suspend fun getCatalog(): List<CatalogAppDto>

    // Получение информации об одном приложении
    @GET("{id}")
    suspend fun getAppById(
        @Path("id") id: String
    ): AppDetailsDto
}
