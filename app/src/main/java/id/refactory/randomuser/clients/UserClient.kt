package id.refactory.randomuser.clients

import com.google.gson.GsonBuilder
import id.refactory.randomuser.services.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserClient {
    companion object {
        fun service(): UserService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder().setLenient().create()
                    )
                )
                .build()

            return retrofit.create(UserService::class.java)
        }
    }
}