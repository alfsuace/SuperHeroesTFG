package com.alfsuace.superheroestfg.feature.superhero.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alfsuace.superheroestfg.R
import com.alfsuace.superheroestfg.app.extensions.loadImage
import com.alfsuace.superheroestfg.databinding.ViewItemSuperheroBinding
import com.alfsuace.superheroestfg.feature.superhero.domain.GetSuperHeroesUseCase


class SuperHeroViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ViewItemSuperheroBinding.bind(view)

    fun bind(
        superHero: GetSuperHeroesUseCase.SuperHeroUiModel,
        onClick: (String) -> Unit,
        onFavoriteClick: (String, Boolean) -> Unit
    ) {
        binding.apply {
            itemSuperHeroName.text = superHero.hero.name
            itemSuperHeroSlug.text = superHero.hero.slug
            itemSuperHeroImage.loadImage(superHero.hero.images.sm)

            view.setOnClickListener {
                onClick(superHero.hero.id.toString())
            }

            val isFavorite = superHero.isFavorite
            itemSuperHeroFavorite.setImageResource(
                if (isFavorite) R.drawable.ic_favorite_filled
                else R.drawable.ic_favorite
            )

            itemSuperHeroFavorite.setOnClickListener {
                onFavoriteClick(superHero.hero.id.toString(), isFavorite)
            }
        }
    }
}
