package shradha.com.asteroidroom.data

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import org.json.JSONObject
import shradha.com.asteroidroom.api.parseAsteroidsJsonResult
import java.lang.reflect.Parameter

class AsteroidWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : Worker(appContext, workerParams) {
    override fun doWork(): Result {
        val dao = AsteroidDatabase.getAsteroidDatabase(applicationContext).asteroidDao()
        val asteroidRepository = AsteroidRepository(dao)
        val call = asteroidRepository.getAsteroidData()
        val body = call.execute().body()
        Log.d("AsteroidWorker", "" + body)
        val jsonObject = JSONObject(body)
        val list = parseAsteroidsJsonResult(jsonObject)
        Log.d("AsteroidWorker", "Size" + list.size)

        try {
            val rows = asteroidRepository.insertAsteroid(list)
            if (rows.isEmpty()) {
                return Result.failure()
            }
        } catch (e: SQLiteConstraintException) {
            return Result.failure()
        }

        return Result.success()
    }
}