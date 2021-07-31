package shradha.com.asteroidroom.ui

import android.app.Dialog
import android.content.DialogInterface
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
        } else {
            binding.imageDetailScreen.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.asteroid_safe
                )
            )
        }

        binding.imageAbsoluteMagnitude.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setMessage("Display Something")
            builder.setNegativeButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
        }
        return binding.root
    }

    private fun isPotentiallyHazardous(asteroid: Asteroid?): Boolean {
        return asteroid?.isPotentiallyHazardous ?: false
    }

}