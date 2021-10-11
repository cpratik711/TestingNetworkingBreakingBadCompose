package com.pratik.breakingbadcompose.data.repository

import com.pratik.breakingbadcompose.data.response.CharacterResponse
import com.pratik.breakingbadcompose.utils.Status
import com.pratik.breakingbadcompose.utils.performNetworkCall
import kotlinx.coroutines.flow.Flow
import com.pratik.breakingbadcompose.data.api.CharacterApiService
import com.pratik.breakingbadcompose.data.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val apiService: CharacterApiService) :
    CharacterRepository {
    override suspend fun getAllCharacters(): Flow<Status<CharacterResponse>> {
        return performNetworkCall {
            apiService.getAllCharacters()
        }
    }
}
