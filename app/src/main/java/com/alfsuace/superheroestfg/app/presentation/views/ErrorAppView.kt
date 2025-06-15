package com.alfsuace.superheroestfg.app.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.alfsuace.superheroestfg.R
import com.alfsuace.superheroestfg.app.extensions.hide
import com.alfsuace.superheroestfg.app.extensions.visible
import com.alfsuace.superheroestfg.databinding.ViewErrorBinding

class ErrorAppView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val binding = ViewErrorBinding
        .inflate(LayoutInflater.from(context), this, true)

    init {
        inflate(this.context, R.layout.view_error, this)
        hide()

    }

    fun render(errorAppUI: ErrorAppUI) {
        binding.imageError.setImageResource(errorAppUI.getImageError())
        binding.titleError.text = errorAppUI.getTitleError()
        binding.descriptionError.text = errorAppUI.getDescriptionError()
        visible()

    }

}