package com.alfsuace.superheroestfg.feature.superhero.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfsuace.superheroestfg.R
import com.alfsuace.superheroestfg.app.domain.ErrorApp
import com.alfsuace.superheroestfg.app.extensions.hide
import com.alfsuace.superheroestfg.app.presentation.views.ErrorAppUIFactory
import com.alfsuace.superheroestfg.databinding.FragmentSuperHeroesBinding
import com.alfsuace.superheroestfg.feature.superhero.presentation.adapter.SuperHeroAdapter
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import org.koin.androidx.viewmodel.ext.android.viewModel


class SuperHeroesFragment : Fragment() {

    private var _binding: FragmentSuperHeroesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SuperHeroViewModel by viewModel()
    private lateinit var superheroAdapter: SuperHeroAdapter
    private lateinit var skeleton: Skeleton
    private var buttonListForView = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperHeroesBinding.inflate(inflater, container, false)
        setUpView()
        return binding.root
    }

    private fun setUpView() {
        superheroAdapter = SuperHeroAdapter()
        binding.apply {
            superHeroToolbar.mainToolBar.apply {
                menu.clear()
                inflateMenu(R.menu.menu_super_hero_favorite)
                setOnMenuItemClickListener { menuItem ->
                    if (menuItem.itemId == R.id.action_go_to_favorites) {
                        buttonListForView = !buttonListForView
                        updateList(menuItem)
                        true
                    } else {
                        false
                    }
                }
            }
            superHeroList.apply {
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = superheroAdapter

                superheroAdapter.setEvent(
                    onClick = { navigateToSuperHeroDetail(it) },
                    onFavoriteClick = { id, isFavorite ->
                        if (isFavorite) {
                            viewModel.deleteFavoriteSuperHero(id)
                        } else {
                            viewModel.saveFavoriteSuperHero(id)
                        }
                    }
                )

                skeleton = applySkeleton(R.layout.view_item_superhero, 15)
            }
        }
    }

    private fun updateList(menuItem: MenuItem) {
        if (buttonListForView) {
            menuItem.icon =
                AppCompatResources.getDrawable(requireContext(), R.drawable.ic_favorite_filled)
            viewModel.getFavoriteSuperHeroes()
        } else {
            menuItem.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_favorite)
            viewModel.getSuperHeroes()
        }

    }

    private fun navigateToSuperHeroDetail(superHeroId: String) {
        val action =
            SuperHeroesFragmentDirections.actionSuperHeroesFragmentToSuperHeroDetailFragment(
                superHeroId
            )
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getSuperHeroes()
    }

    private fun setupObservers() {
        val observer = Observer<SuperHeroViewModel.UiState> {
            if (it.isLoading) {
                skeleton.showSkeleton()
            } else {
                skeleton.showOriginal()
                if (it.errorApp != null) {
                    bindError(it.errorApp)
                } else {
                    superheroAdapter.submitList(it.superHeroes)
                }
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun bindError(errorApp: ErrorApp) {
        if (errorApp != null) {
            val error = ErrorAppUIFactory(requireContext())
            val errorView = error.build(errorApp)
            binding.superHeroSkeletonLayout.visibility = View.GONE
            binding.errorSuperHeroList.render(errorView)
        } else {
            binding.superHeroSkeletonLayout.visibility = View.VISIBLE
            binding.errorSuperHeroList.hide()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}