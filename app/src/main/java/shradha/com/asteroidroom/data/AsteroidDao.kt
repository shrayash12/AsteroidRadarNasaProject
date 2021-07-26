package shradha.com.asteroidroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AsteroidDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAsteroid(asteroid: Asteroid)

    @Query("SELECT * from AsteroidTable ORDER By closeApproachDate")
    suspend fun getAsteroid(): List<Asteroid>

    @Query("DELETE from AsteroidTable")
    fun deleteAll()
}