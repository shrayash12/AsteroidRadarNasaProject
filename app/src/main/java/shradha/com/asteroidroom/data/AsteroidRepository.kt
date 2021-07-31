package shradha.com.asteroidroom.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import shradha.com.asteroidroom.api.MyApi
import shradha.com.asteroidroom.api.MyImageApi
import shradha.com.asteroidroom.util.Constants
import shradha.com.asteroidroom.util.Utility


class AsteroidRepository(private val asteroidDao: AsteroidDao) {
    fun getAllAsteroid(): Flow<List<Asteroid>> = asteroidDao.getAsteroid()
    fun insertAsteroid(asteroid: List<Asteroid>): List<Long> {
        return asteroidDao.insertAsteroid(asteroid)
    }

    suspend fun getAsteroidImages(): AsteroidImageResponse {
        return MyImageApi.createImageService().getAsteroidImages(Constants.API_KEY_FOR_IMAGE)
    }

    fun getAsteroidData(): Call<String> {
        return MyApi.getServiceForAsteroid()
            .getAsteroidResponse(Utility.getToday(), Utility.getSeventhDay(), Constants.API_KEY)
    }

}