package shradha.com.asteroidroom.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import shradha.com.asteroidroom.util.Constants

object MyImageApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL_FOR_IMAGE)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
        .build()

    fun createImageService(): AsteroidService {
        return retrofit.create(AsteroidService::class.java)
    }
}