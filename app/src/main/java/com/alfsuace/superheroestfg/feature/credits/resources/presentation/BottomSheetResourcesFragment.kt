package com.alfsuace.superheroestfg.feature.credits.resources.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfsuace.superheroestfg.databinding.FragmentBottomSheetResourcesBinding
import com.alfsuace.superheroestfg.feature.credits.resources.presentation.adapter.ResourceAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class BottomSheetResourcesFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetResourcesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ResourcesViewModel by viewModel()
    lateinit var resourceAdapter: ResourceAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetResourcesBinding.inflate(inflater, container, false)
        setUpView()
        return binding.root
    }

    private fun setUpView() {
        resourceAdapter = ResourceAdapter()
        binding.apply {
            resourcesRecyclerList.apply {
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = resourceAdapter
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        viewModel.getResources()
    }

    private fun setUpObservers() {
        val observer = Observer<ResourcesViewModel.UiState> {
            if (it.errorApp == null) {
                resourceAdapter.submitList(it.resources)
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}