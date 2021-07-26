package shradha.com.asteroidroom.api

import retrofit2.http.GET
import retrofit2.http.Query
import shradha.com.asteroidroom.data.AsteroidImageResponse
import shradha.com.asteroidroom.util.Constants

interface AsteroidService {
    @GET(Constants.PATH_FOR_IMAGE)
    suspend fun getAsteroidImages(@Query("api_key") api_key: String): AsteroidImageResponse

}