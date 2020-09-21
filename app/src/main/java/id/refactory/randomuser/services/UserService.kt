package id.refactory.randomuser.services

import id.refactory.randomuser.models.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UserService {
    @GET("api")
    @Headers("Accept: application/json")
    fun getUser(@Query("results") result: Int): Call<Result>
}