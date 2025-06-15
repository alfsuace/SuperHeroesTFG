package com.alfsuace.superheroestfg.feature.superhero.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alfsuace.superheroestfg.R
import com.alfsuace.superheroestfg.app.extensions.loadImage
import com.alfsuace.superheroestfg.databinding.FragmentSuperHeroDetailBinding
import com.alfsuace.superheroestfg.feature.superhero.domain.SuperHero
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuperHeroDetailFragment : Fragment() {

    private val args: SuperHeroDetailFragmentArgs by navArgs()

    private var _binding: FragmentSuperHeroDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SuperHeroDetailViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperHeroDetailBinding.inflate(inflater, container, false)
        setUpView()
        return binding.root
    }

    private fun setUpView() {
        binding.heroDetailToolbar.genericToolBar.apply {
            title = requireContext().getString(R.string.detail_hero_toolbar_title)
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getSuperHeroById(args.SuperHeroId)
    }

    private fun setupObservers() {
        val observer = Observer<SuperHeroDetailViewModel.UiState> {
            it.superHero?.let { superHero -> bindData(superHero = superHero) }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)

    }

    private fun bindData(superHero: SuperHero) {
        bindDataName(superHero)
        bindDataStats(superHero)
        bindDataBiography(superHero)
        bindDataWork(superHero)
    }

    private fun bindDataName(superHero: SuperHero) {
        binding.apply {

            detailHeroImage.loadImage(superHero.images.lg)

            val name = requireContext().getString(R.string.super_heroes_name)
            detailHeroName.setStatName(name)
            detailHeroName.setStatValue(superHero.name)

            val slug = requireContext().getString(R.string.detail_hero_slug)
            detailHeroSlug.setStatName(slug)
            superHero.slug?.let { detailHeroSlug.setStatValue(it) }

        }
    }

    private fun bindDataStats(superHero: SuperHero) {
        binding.apply {
            val intelligence = requireContext().getString(R.string.detail_hero_intelligence)
            detailHeroIntelligence.setStatName(intelligence)
            detailHeroIntelligence.setStatValue(superHero.powerStats.intelligence.toString())

            val strength = requireContext().getString(R.string.detail_hero_strength)
            detailHeroStrength.setStatName(strength)
            detailHeroStrength.setStatValue(superHero.powerStats.strength.toString())

            val speed = requireContext().getString(R.string.detail_hero_speed)
            detailHeroSpeed.setStatName(speed)
            detailHeroSpeed.setStatValue(superHero.powerStats.speed.toString())

            val durability = requireContext().getString(R.string.detail_hero_durability)
            detailHeroDurability.setStatName(durability)
            detailHeroDurability.setStatValue(superHero.powerStats.durability.toString())

            val power = requireContext().getString(R.string.detail_hero_power)
            detailHeroPower.setStatName(power)
            detailHeroPower.setStatValue(superHero.powerStats.power.toString())

            val combat = requireContext().getString(R.string.detail_hero_combat)
            detailHeroCombat.setStatName(combat)
            detailHeroCombat.setStatValue(superHero.powerStats.combat.toString())
        }
    }

    private fun bindDataBiography(superHero: SuperHero) {
        binding.apply {

            val fullName = requireContext().getString(R.string.detail_hero_full_name)
            detailHeroFullName.setStatName(fullName)
            detailHeroFullName.setStatValue(superHero.biography.fullName)

            val alterEgo = requireContext().getString(R.string.detail_hero_alter_egos)
            detailHeroAlterEgo.setStatName(alterEgo)
            detailHeroAlterEgo.setStatValue(superHero.biography.alterEgos)

            val birthplace = requireContext().getString(R.string.detail_hero_birth)
            detailHeroBirthplace.setStatName(birthplace)
            detailHeroBirthplace.setStatValue(superHero.biography.placeOfBirth)
        }
    }

    private fun bindDataWork(superHero: SuperHero) {
        binding.apply {

            val occupation = requireContext().getString(R.string.detail_hero_occupation)
            detailHeroOccupation.setStatName(occupation)
            detailHeroOccupation.setStatValue(superHero.work.occupation)

            val base = requireContext().getString(R.string.detail_hero_base)
            detailHeroBase.setStatName(base)
            detailHeroBase.setStatValue(superHero.work.base)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}