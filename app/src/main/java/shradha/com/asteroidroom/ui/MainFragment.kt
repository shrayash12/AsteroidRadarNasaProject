package shradha.com.asteroidroom.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_main.*
import shradha.com.asteroidroom.R
import shradha.com.asteroidroom.databinding.FragmentMainBinding
import shradha.com.asteroidroom.domain.AsteroidAdapter
import shradha.com.asteroidroom.domain.AsteroidViewModel
import shradha.com.asteroidroom.domain.ViewModelFactory

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater,
            R.id.action_mainFragment_to_detailFragment,
            container,
            false
        )
        val asteroidViewModel: AsteroidViewModel by viewModels {
            ViewModelFactory((activity?.application as MyApplication).repo)
        }
/*        val asteroidAdapter = AsteroidAdapter()
        recyclerViewInMainScreen.adapter = asteroidAdapter
        recyclerViewInMainScreen.layoutManager = LinearLayoutManager(requireActivity())
        asteroidViewModel.getAsteroidFromRepo()
        asteroidViewModel.liveData.observe(requireActivity(), Observer {
            asteroidAdapter.submitList(it)
        })*/
        asteroidViewModel.livedataForImage.observe(requireActivity(), Observer {
            Log.d("MainFragment", it.url)
            if (it.url.isNotBlank()) {
                Glide
                    .with(this)
                    .load(it.hdurl)
                    .centerCrop()
                    .into(binding.imageMainScreen)
            }
        })
        return binding.root
    }
}
