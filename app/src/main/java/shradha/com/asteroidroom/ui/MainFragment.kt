package shradha.com.asteroidroom.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.bumptech.glide.Glide
import shradha.com.asteroidroom.R
import shradha.com.asteroidroom.data.Asteroid
import shradha.com.asteroidroom.data.AsteroidWorker
import shradha.com.asteroidroom.databinding.FragmentMainBinding
import shradha.com.asteroidroom.domain.AsteroidAdapter
import shradha.com.asteroidroom.domain.AsteroidViewModel
import shradha.com.asteroidroom.domain.OnAsteroidItemClickListener
import shradha.com.asteroidroom.domain.ViewModelFactory

class MainFragment : Fragment(), OnAsteroidItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val saveRequests =
            PeriodicWorkRequestBuilder<AsteroidWorker>(1, java.util.concurrent.TimeUnit.SECONDS)
                .setConstraints(constraints)
                .build()
        WorkManager.getInstance(requireActivity())
            .enqueue(saveRequests)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )

        val asteroidViewModel: AsteroidViewModel by viewModels {
            ViewModelFactory((activity?.application as MyApplication).repo)
        }


        asteroidViewModel.getAsteroidFromRepo()
        val asteroidAdapter = AsteroidAdapter()
        asteroidAdapter.setOnAsteroidItemClickListener(this)
        binding.recyclerViewInMainScreen.adapter = asteroidAdapter
        binding.recyclerViewInMainScreen.layoutManager = LinearLayoutManager(requireActivity())
        asteroidViewModel.getAsteroidFromRepo()
        asteroidViewModel.liveData.observe(requireActivity(), Observer {
            asteroidAdapter.submitList(it)
        })
        asteroidViewModel.liveDataForImage.observe(requireActivity(), Observer {
            Log.d("MainFragment", it.url)
            if (it.url.isNotBlank()) {

                Glide
                    .with(this)
                    .load(it.hdurl)
                    .centerCrop()
                    .into(binding.imageMainScreen)
            } else {
                binding.imageMainScreen.setImageResource(R.drawable.asteroid_default)
            }
        })
        return binding.root
    }

    override fun onAsteroidItemClick(asteroid: Asteroid) {
        val bundle = Bundle()
        bundle.putParcelable("asteroid", asteroid)
        Navigation.findNavController(requireView())
            .navigate(R.id.action_mainFragment_to_detailFragment, bundle)
    }


}
