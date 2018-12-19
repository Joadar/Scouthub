package com.jonathan_pannetier.scouthub.data.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jonathan_pannetier.scouthub.BuildConfig
import com.jonathan_pannetier.scouthub.ENDPOINT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIManager {

    private var privOkHttpClient: OkHttpClient? = null

    val apiGithubService: GithubService by lazy {
        apiGithubRetrofit.create(GithubService::class.java)
    }

    private val gson: Gson by lazy {
        GsonBuilder()
            .setLenient()
            .create()
    }

    private val okHttpClient: OkHttpClient
        get() {
            if (privOkHttpClient == null) {
                val builder = OkHttpClient.Builder()

                builder.connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)

                if (BuildConfig.DEBUG) {
                    builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                }

                privOkHttpClient = builder.build()
            }
            return privOkHttpClient as OkHttpClient

        }

    private val apiGithubRetrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(ENDPOINT)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

}