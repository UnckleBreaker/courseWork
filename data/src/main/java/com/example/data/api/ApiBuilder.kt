package com.example.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


class ApiBuilder {
//    companion object {
//        private var retrofit: Retrofit? = null
//
//        fun retrofitBuilder(baseurl :String): Retrofit {
//            if(retrofit==null){
//                retrofit= Retrofit.Builder()
//                    .baseUrl(baseurl)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .build()
//            }
//            return retrofit!!
//
//        }
//        fun getHttpClient(): OkHttpClient {
//            val logging = HttpLoggingInterceptor()
//            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//            return OkHttpClient.Builder()
//                .connectTimeout(300, TimeUnit.SECONDS)
//                .readTimeout(300, TimeUnit.SECONDS).addInterceptor(logging).build()
//        }
//    }
}