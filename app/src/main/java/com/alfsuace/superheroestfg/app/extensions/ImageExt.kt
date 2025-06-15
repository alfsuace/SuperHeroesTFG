package com.alfsuace.superheroestfg.app.extensions

import android.widget.ImageView
import coil.load

fun ImageView.loadImage(url: String) {
    this.load(url)
}