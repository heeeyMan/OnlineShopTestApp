package com.example.onlineshop.services

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.onlineshop.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DataClient {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getInstance(): Retrofit {
        val timeOut: Long = 120
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val mOkHttpClient = OkHttpClient
            .Builder()
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
    }

}