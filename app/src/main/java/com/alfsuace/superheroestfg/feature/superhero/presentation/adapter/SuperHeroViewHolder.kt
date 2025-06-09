package com.alfsuace.superheroestfg.feature.superhero.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alfsuace.superheroestfg.app.data.extensions.loadImage
import com.alfsuace.superheroestfg.databinding.ViewItemSuperheroBinding
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero

class SuperHeroViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ViewItemSuperheroBinding.bind(view)

    fun bind(superHero: SuperHero) {
        binding.apply {
            itemSuperHeroName.text = superHero.name
            itemSuperHeroSlug.text = superHero.slug
            itemSuperHeroImage.loadImage(superHero.images.sm)
        }
    }
}