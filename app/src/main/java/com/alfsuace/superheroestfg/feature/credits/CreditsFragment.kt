package com.alfsuace.superheroestfg.feature.credits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alfsuace.superheroestfg.R
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
        bindData()
    }

    private fun bindData() {
        binding.centerCardText.text = requireContext().getString(R.string.credits_text)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}