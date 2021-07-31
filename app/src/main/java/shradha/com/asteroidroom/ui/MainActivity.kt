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
    }
}