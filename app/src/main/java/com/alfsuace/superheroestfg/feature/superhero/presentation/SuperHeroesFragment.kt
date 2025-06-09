package com.alfsuace.superheroestfg.feature.superhero.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfsuace.superheroestfg.R
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
            superHeroList.apply {
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = superheroAdapter
                skeleton = applySkeleton(R.layout.view_item_superhero, 15)
            }
        }
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
                    //TODO showError(it.errorApp)
                } else {
                    superheroAdapter.submitList(it.superHeroes)
                }
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}