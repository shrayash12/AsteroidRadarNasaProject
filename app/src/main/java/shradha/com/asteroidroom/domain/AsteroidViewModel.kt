package shradha.com.asteroidroom.domain

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import shradha.com.asteroidroom.data.Asteroid
import shradha.com.asteroidroom.data.AsteroidImageResponse
import shradha.com.asteroidroom.data.AsteroidRepository

class AsteroidViewModel(private val asteroidRepository: AsteroidRepository) : ViewModel() {
    val liveData: LiveData<List<Asteroid>> = asteroidRepository.getAllAsteroid().asLiveData()

    //For Asteroid Image
    private val mutableLiveDataForImage = MutableLiveData<AsteroidImageResponse>()
    val liveDataForImage: LiveData<AsteroidImageResponse> get() = mutableLiveDataForImage

    fun getAsteroidFromRepo() {
        viewModelScope.launch(Dispatchers.IO) {
            val imageResponse = asteroidRepository.getAsteroidImages()
            mutableLiveDataForImage.postValue(imageResponse)
        }
    }

}