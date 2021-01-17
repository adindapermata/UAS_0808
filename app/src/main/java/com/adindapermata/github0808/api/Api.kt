package com.adindapermata.github0808.api

import com.adindapermata.github0808.data.model.DetailUserResponse
import com.adindapermata.github0808.data.model.User
import com.adindapermata.github0808.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 274ba64606c9a1ce39dc8dc56b78b1128e21edfb")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 274ba64606c9a1ce39dc8dc56b78b1128e21edfb")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 274ba64606c9a1ce39dc8dc56b78b1128e21edfb")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 274ba64606c9a1ce39dc8dc56b78b1128e21edfb")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}