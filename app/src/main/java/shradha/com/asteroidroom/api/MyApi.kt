package shradha.com.asteroidroom.api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import shradha.com.asteroidroom.util.Constants

object MyApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    fun getServiceForAsteroid(): AsteroidService {
        return retrofit.create(AsteroidService::class.java)
    }
}