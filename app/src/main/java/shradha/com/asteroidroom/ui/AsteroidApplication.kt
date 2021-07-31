package shradha.com.asteroidroom.ui

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import shradha.com.asteroidroom.data.AsteroidDatabase
import shradha.com.asteroidroom.data.AsteroidRepository

class AsteroidApplication : Application() {
    private val db by lazy { AsteroidDatabase.getAsteroidDatabase(this) }
    val repo by lazy { AsteroidRepository(db.asteroidDao()) }
}
