package com.adindapermata.github0808.api

import com.adindapermata.github0808.data.model.DetailUserResponse
import com.adindapermata.github0808.data.model.User
import com.adindapermata.github0808.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("search/users")
    @Headers("Authorization: token daa1fb3f4a920d5e09b86ee45f008612eba8b3d1")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token daa1fb3f4a920d5e09b86ee45f008612eba8b3d1")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token daa1fb3f4a920d5e09b86ee45f008612eba8b3d1")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token daa1fb3f4a920d5e09b86ee45f008612eba8b3d1")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}