package com.alfsuace.superheroestfg.feature.credits.developer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.alfsuace.superheroestfg.databinding.FragmentDeveloperBottomSheetBinding
import com.alfsuace.superheroestfg.feature.credits.developer.domain.Developer
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeveloperBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentDeveloperBottomSheetBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DeveloperViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeveloperBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        viewModel.getDeveloper()
    }

    private fun setUpObservers() {
        val observer = Observer<DeveloperViewModel.UiState> {
            bindData(it.resources)
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun bindData(developer: Developer?) {
        binding.apply {
            developerName.text = developer?.name
        }

    }
}