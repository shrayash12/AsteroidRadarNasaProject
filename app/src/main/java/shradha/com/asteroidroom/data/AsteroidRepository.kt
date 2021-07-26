package shradha.com.asteroidroom.data

import shradha.com.asteroidroom.api.MyImageApi
import shradha.com.asteroidroom.util.Constants


class AsteroidRepository(private val asteroidDao: AsteroidDao) {
    suspend fun getAllAsteroid(): List<Asteroid> = asteroidDao.getAsteroid()
    suspend fun insertAsteroid(asteroid: Asteroid) {
        asteroidDao.insertAsteroid(asteroid)
    }

    suspend fun getAsteroidImages(): AsteroidImageResponse {
        return MyImageApi.createImageService().getAsteroidImages(Constants.API_KEY_FOR_IMAGE)
    }

}