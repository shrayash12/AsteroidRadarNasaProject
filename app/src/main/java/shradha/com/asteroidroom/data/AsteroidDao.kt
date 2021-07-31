package shradha.com.asteroidroom.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AsteroidDao {
    @Transaction
    suspend fun updateAsteroid(asteroid: List<Asteroid>) {
        deleteAll()
        insertAsteroid(asteroid)
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAsteroid(asteroid: List<Asteroid>): List<Long>

    @Query("SELECT * from AsteroidTable ORDER By closeApproachDate")
    fun getAsteroid(): Flow<List<Asteroid>>

    @Query("DELETE from AsteroidTable")
    fun deleteAll()
}