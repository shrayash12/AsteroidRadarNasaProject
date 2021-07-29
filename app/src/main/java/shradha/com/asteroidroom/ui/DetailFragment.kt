package shradha.com.asteroidroom.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import shradha.com.asteroidroom.R
import shradha.com.asteroidroom.data.Asteroid
import shradha.com.asteroidroom.databinding.FragmentDetailBinding


@Suppress("DEPRECATION")
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        val asteroid = arguments?.getParcelable<Asteroid>("asteroid")
        binding.tvCloseApproachDate.text = asteroid?.closeApproachDate
        binding.tvAbsoluteMagnitude.text = asteroid?.absoluteMagnitude.toString()
        binding.tvEstimatedDiameter.text = asteroid?.estimatedDiameter.toString()
        binding.tvDistanceFromEarth.text = asteroid?.distanceFromEarth.toString()
        binding.tvRelativeVelocity.text = asteroid?.relativeVelocity.toString()
        val stringH =  isPotentiallyHazardous(asteroid)
        binding.tvIsHazardous.text = stringH

        if(stringH == "Potentially Hazardous") {
            binding.tvIsHazardous.setTextColor(requireActivity().resources.getColor(R.color.hazardous))

        } else {
            binding.tvIsHazardous.setTextColor(Color.WHITE)

        }

        Glide
            .with(this)
            .load(asteroid?.url)
            .centerCrop()
            .into(binding.imageDetailScreen)

        Log.d("Detail Screen", "" + asteroid?.codename)

        return binding.root
    }

    private fun isPotentiallyHazardous(asteroid: Asteroid?): String {
        val isTrue = asteroid?.isPotentiallyHazardous ?: false
        return if (isTrue) {
            "Potentially Hazardous"
        } else {
            "Potentially not Hazardous"

        }
    }

}