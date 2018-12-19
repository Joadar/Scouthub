package com.jonathan_pannetier.scouthub.data.remote

import com.jonathan_pannetier.scouthub.data.models.Repository
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("/users/{username}/repos")
    fun getRepositories(
        @Path("username") username: String,
        @Query("per_page") itemPerPage: Int,
        @Query("page") currentPage: Int
    ): Deferred<List<Repository>>
}