package shradha.com.asteroidroom.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import shradha.com.asteroidroom.data.AsteroidRepository


class ViewModelFactory(private val asteroidRepository: AsteroidRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AsteroidViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AsteroidViewModel(asteroidRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}