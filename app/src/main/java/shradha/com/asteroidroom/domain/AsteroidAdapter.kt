package shradha.com.asteroidroom.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import shradha.com.asteroidroom.R
import shradha.com.asteroidroom.data.Asteroid

class AsteroidAdapter :
    androidx.recyclerview.widget.ListAdapter<Asteroid, AsteroidAdapter.AsteroidViewHolder>(
        AsteroidViewHolder.COMPARATORS
    ) {
    class AsteroidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCloseApproachDate = itemView.findViewById<TextView>(R.id.tvCloseApproachDate)
        private val tvAbsoluteMagnitude = itemView.findViewById<TextView>(R.id.tvAbsoluteMagnitude)
        private val tvEstimatedDiameter = itemView.findViewById<TextView>(R.id.tvEstimatedDiameter)
        private val tvRelativeVelocity = itemView.findViewById<TextView>(R.id.tvRelativeVelocity)
        private val tvDistanceFromEarth = itemView.findViewById<TextView>(R.id.tvDistanceFromEarth)

        fun bind(asteroid: Asteroid) {
            tvCloseApproachDate.text = asteroid.closeApproachDate
            tvAbsoluteMagnitude.text = asteroid.absoluteMagnitude.toString()
            tvEstimatedDiameter.text = asteroid.estimatedDiameter.toString()
            tvRelativeVelocity.text = asteroid.relativeVelocity.toString()
            tvDistanceFromEarth.text = asteroid.distanceFromEarth.toString()
        }

        object COMPARATORS : DiffUtil.ItemCallback<Asteroid>() {
            override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
                return oldItem.id === newItem.id
            }

            override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        return AsteroidViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}