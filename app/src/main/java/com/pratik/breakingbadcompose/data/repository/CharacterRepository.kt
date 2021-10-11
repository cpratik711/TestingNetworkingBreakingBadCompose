package com.pratik.breakingbadcompose.data.repository

import com.pratik.breakingbadcompose.data.response.CharacterResponse
import com.pratik.breakingbadcompose.utils.Status
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getAllCharacters(): Flow<Status<CharacterResponse>>
}
