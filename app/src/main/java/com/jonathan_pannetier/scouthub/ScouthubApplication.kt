package com.jonathan_pannetier.scouthub

import android.app.Application
import com.jonathan_pannetier.scouthub.data.remote.APIManager
import com.jonathan_pannetier.scouthub.data.remote.GithubService

class ScouthubApplication : Application() {

    // Need to improve dependency injection
    val githubService: GithubService by lazy { APIManager().apiGithubService }

}