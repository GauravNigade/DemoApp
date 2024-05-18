package com.example.demo_app.ViewModel.API_Interface

import android.content.Context
import com.example.demo_app.Model.RequestModel.CustomerRequestModel
import com.example.demo_app.Model.ResponseModel.CustumerResponseModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Route
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.net.Authenticator
import java.util.concurrent.TimeUnit

interface API_Interface {


    companion object {

        fun create(): API_Interface {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val gson = Gson()

            val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://dairyerpservice.eanifarm.com/")
                .client(okHttpClient)
                .build()
            return retrofit.create(API_Interface::class.java)
        }
    }

    @POST("service.asmx/download_table_CA_2_0")
    fun getCustomerData(@Body requestModel: CustomerRequestModel): Call<CustumerResponseModel>

}