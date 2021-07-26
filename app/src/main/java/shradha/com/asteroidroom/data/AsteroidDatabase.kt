package shradha.com.asteroidroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Asteroid::class], version = 1, exportSchema = false)
abstract class AsteroidDatabase : RoomDatabase() {
    abstract fun asteroidDao(): AsteroidDao

    companion object {
        @Volatile
        var INSTANCE: AsteroidDatabase? = null
        fun getAsteroidDatabase(context: Context): AsteroidDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, AsteroidDatabase::class.java, "Asteroid-db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as AsteroidDatabase
        }

    }
}