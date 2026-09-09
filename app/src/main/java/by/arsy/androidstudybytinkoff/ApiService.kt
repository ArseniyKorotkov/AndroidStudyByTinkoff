package by.arsy.androidstudybytinkoff

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users/{user}.json")
    fun getOperations(
        @Path("user") user: String
    ) : Call<Operations>


    @GET("users")
    fun getUsers(
        @Query("since") since: Int,
        @Query("since") perAge: Int,
    ): Call<List<User>>

    @POST("users/new")
    fun createUser(
        @Body user: User
    )
}

@Serializable
data class User(
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
)
@Serializable
data class Repo(
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
)