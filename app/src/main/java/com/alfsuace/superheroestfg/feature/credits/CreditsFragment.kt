package com.alfsuace.superheroestfg.feature.credits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alfsuace.superheroestfg.databinding.FragmentCreditsBinding


class CreditsFragment : Fragment() {


    private var _binding: FragmentCreditsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreditsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        binding.apply {
            creditsResourcesCard.setOnClickListener {
                findNavController().navigate(CreditsFragmentDirections.actionCreditFragmentToBottomSheetResourcesFragment())
            }

            creditsDeveloperCard.setOnClickListener {
                findNavController().navigate(CreditsFragmentDirections.actionCreditFragmentToDeveloperBottomSheetFragment())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}