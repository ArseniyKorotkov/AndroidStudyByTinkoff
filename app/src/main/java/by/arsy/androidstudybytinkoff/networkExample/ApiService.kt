package by.arsy.androidstudybytinkoff.networkExample

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("endpoint")
    fun getData() : Call<List<MyDataModel>>

}