package com.picpay.desafio.android.data.service

import com.google.gson.Gson
import com.picpay.desafio.android.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val BASE_URL = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
    private const val READ_TIMEOUT = 20L
    private const val CONNECT_TIMEOUT = 20L
    private val log = HttpLoggingInterceptor()

    init {
        if (BuildConfig.DEBUG) log.level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttp = OkHttpClient
        .Builder()
        .addInterceptor(log)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .client(okHttp)
        .baseUrl(BASE_URL)
        .build()

    val picPayService: PicPayService by lazy { retrofit.create(PicPayService::class.java) }

}