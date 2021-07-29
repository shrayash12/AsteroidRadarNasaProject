package shradha.com.asteroidroom.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import shradha.com.asteroidroom.R
import shradha.com.asteroidroom.data.Asteroid

class AsteroidAdapter :
    androidx.recyclerview.widget.ListAdapter<Asteroid, AsteroidAdapter.AsteroidViewHolder>(
        AsteroidViewHolder.COMPARATORS
    ) {
    private lateinit var onAsteroidItemClickListener: OnAsteroidItemClickListener

    class AsteroidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCodeName = itemView.findViewById<TextView>(R.id.tvCodeName)
        private val tvDate = itemView.findViewById<TextView>(R.id.tvDate)
        private val smileyImage = itemView.findViewById<ImageView>(R.id.smileyImage)
        private val imageAbsoluteMagnitude =
            itemView.findViewById<ImageView>(R.id.imageAbsoluteMagnitude)

        fun bind(asteroid: Asteroid) {
            tvCodeName.text = asteroid.codename
            tvDate.text = asteroid.closeApproachDate
            if (asteroid.isPotentiallyHazardous) {
                smileyImage.setImageResource(R.drawable.ic_hazardous_face_foreground)
            } else {
                smileyImage.setImageResource(R.drawable.ic_smiley_face_foreground)
            }
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
            LayoutInflater.from(parent.context).inflate(R.layout.asteroid_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.setOnClickListener {
            onAsteroidItemClickListener.onAsteroidItemClick(getItem(position))
        }
    }

    fun setOnAsteroidItemClickListener(onAsteroidItemClickListener: OnAsteroidItemClickListener) {
        this.onAsteroidItemClickListener = onAsteroidItemClickListener
    }
}


interface OnAsteroidItemClickListener {
    fun onAsteroidItemClick(asteroid: Asteroid)
}