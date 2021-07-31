package shradha.com.asteroidroom.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import shradha.com.asteroidroom.data.Asteroid
import shradha.com.asteroidroom.data.AsteroidImageResponse
import shradha.com.asteroidroom.util.Constants

interface AsteroidService {
    @GET(Constants.PATH_FOR_IMAGE)
    suspend fun getAsteroidImages(@Query("api_key") api_key: String): AsteroidImageResponse

    @GET("neo/rest/v1/feed")
    fun getAsteroidResponse(
        @Query("start_date") start_date: String,
        @Query("end_date") end_date: String,
        @Query("api_key") api_key: String
    ): Call<String>
}