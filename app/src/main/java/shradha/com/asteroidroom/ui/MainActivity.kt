package shradha.com.asteroidroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import shradha.com.asteroidroom.R
import shradha.com.asteroidroom.data.Asteroid
import shradha.com.asteroidroom.domain.AsteroidAdapter
import shradha.com.asteroidroom.domain.AsteroidViewModel
import shradha.com.asteroidroom.domain.ViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     /*   val imageDetailScreen: ImageView = findViewById(R.id.imageDetailScreen)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewInDetailScreen)
        val asteroidViewModel: AsteroidViewModel by viewModels {
            ViewModelFactory((application as MyApplication).repo)
        }
        asteroidViewModel.insertAsteroid(
            asteroid = Asteroid(
                2,
                "Asteroid Codename",
                "2021-07-26",
                23.040,
                44.3893,
                4550.2,
                110.00,
                false
            )
        )
        val asteroidAdapter = AsteroidAdapter()
        recyclerView.adapter = asteroidAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        asteroidViewModel.getAsteroidFromRepo()
        asteroidViewModel.liveData.observe(this, Observer {
            asteroidAdapter.submitList(it)
        })
        asteroidViewModel.livedataForImage.observe(this, Observer {
            Log.d("MainActivity", it.url)
            if (it.url.isNotBlank()){
                Glide
                    .with(this)
                    .load(it.hdurl)
                    .centerCrop()
                    .into(imageDetailScreen)

            }

        })

      */
    }


}