package com.alfsuace.superheroestfg.feature.superhero.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.alfsuace.superheroestfg.databinding.ViewStatItemBinding

class StatItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = ViewStatItemBinding.inflate(LayoutInflater.from(context), this, true)

    fun setItemValues(stat: String, value: String) {
        binding.apply {
            leftText.text = stat
            rightText.text = value
        }
    }

    fun setStatName(stat: String) {
        binding.leftText.text = stat
    }

    fun setStatValue(value: String) {
        binding.rightText.text = value
    }

}