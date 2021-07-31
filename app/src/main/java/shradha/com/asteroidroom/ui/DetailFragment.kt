package shradha.com.asteroidroom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import shradha.com.asteroidroom.R
import shradha.com.asteroidroom.data.Asteroid
import shradha.com.asteroidroom.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val asteroid = arguments?.getParcelable<Asteroid>("asteroid")

        binding.tvCloseApproachDate.text = asteroid?.closeApproachDate
        binding.tvAbsoluteMagnitude.text = asteroid?.absoluteMagnitude.toString()
        binding.tvEstimatedDiameter.text = asteroid?.estimatedDiameter.toString()
        binding.tvDistanceFromEarth.text = asteroid?.distanceFromEarth.toString()
        binding.tvRelativeVelocity.text = asteroid?.relativeVelocity.toString()

        if (isPotentiallyHazardous(asteroid)) {
            binding.imageDetailScreen.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.asteroid_hazardous
                )
            )
            binding.imageDetailScreen.contentDescription =
                resources.getString(R.string.potentially_hazardous_description)
        } else {
            binding.imageDetailScreen.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.asteroid_safe
                )
            )
            binding.imageDetailScreen.contentDescription =
                resources.getString(R.string.potentially_non_hazardous_description)
        }

        binding.imageAbsoluteMagnitude.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setMessage(resources.getString(R.string.dialog_message))
            builder.setNegativeButton(resources.getString(R.string.dialog_text)) { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
        }
        binding.imageAbsoluteMagnitude.contentDescription =
            resources.getString(R.string.magnitude_info)
        return binding.root
    }

    private fun isPotentiallyHazardous(asteroid: Asteroid?): Boolean {
        return asteroid?.isPotentiallyHazardous ?: false
    }

}