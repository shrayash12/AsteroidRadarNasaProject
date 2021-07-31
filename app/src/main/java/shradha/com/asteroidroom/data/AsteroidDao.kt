package shradha.com.asteroidroom.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AsteroidDao {
    @Transaction
    suspend fun updateAsteroid(asteroid: List<Asteroid>) {
        deleteAll()
        insertAsteroid(asteroid)
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertAsteroid(asteroid: List<Asteroid>)

    @Query("SELECT * from AsteroidTable ORDER By closeApproachDate")
    suspend fun getAsteroid(): List<Asteroid>

    @Query("DELETE from AsteroidTable")
    fun deleteAll()
}