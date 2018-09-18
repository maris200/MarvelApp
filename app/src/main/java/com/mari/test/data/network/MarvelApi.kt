package com.mari.test.data.network

import com.mari.test.data.network.dto.CharacterMarvelDto
import com.mari.test.data.network.dto.DataWrapper
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    fun getCharacters(
            @Query("offset") offset: Int?,
            @Query("limit") limit: Int?,
            @Query("nameStartsWith") searchQuery: String?
    ): Single<DataWrapper<List<CharacterMarvelDto>>>
}