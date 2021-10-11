package com.pratik.breakingbadcompose.mapper


import com.pratik.breakingbadcompose.modelmapper.Mapper
import com.pratik.breakingbadcompose.data.response.CharacterResponse
import com.pratik.breakingbadcompose.domain.Character


class CharacterMapper : Mapper<CharacterResponse.CharacterResponseItem, Character> {
    override fun map(input: CharacterResponse.CharacterResponseItem): Character {
        return Character(input.name, input.nickname, input.img)
    }
}

