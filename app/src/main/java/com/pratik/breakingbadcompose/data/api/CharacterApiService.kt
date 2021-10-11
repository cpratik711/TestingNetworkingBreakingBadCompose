package com.pratik.breakingbadcompose.data.api

import com.pratik.breakingbadcompose.data.response.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApiService {
    @GET("api/characters")
    suspend fun getAllCharacters(): Response<CharacterResponse>
}
