package com.pratik.breakingbadcompose.data.response


import com.google.gson.annotations.SerializedName

class CharacterResponse : ArrayList<CharacterResponse.CharacterResponseItem>(){
    data class CharacterResponseItem(
        @SerializedName("appearance")
        val appearance: List<Int>,
        @SerializedName("better_call_saul_appearance")
        val betterCallSaulAppearance: List<Any>,
        @SerializedName("birthday")
        val birthday: String, // 09-24-1984
        @SerializedName("category")
        val category: String, // Breaking Bad
        @SerializedName("char_id")
        val charId: Int, // 2
        @SerializedName("img")
        val img: String, // https://vignette.wikia.nocookie.net/breakingbad/images/9/95/JesseS5.jpg/revision/latest?cb=20120620012441
        @SerializedName("name")
        val name: String, // Jesse Pinkman
        @SerializedName("nickname")
        val nickname: String, // Cap n' Cook
        @SerializedName("occupation")
        val occupation: List<String>,
        @SerializedName("portrayed")
        val portrayed: String, // Aaron Paul
        @SerializedName("status")
        val status: String // Alive
    )
}