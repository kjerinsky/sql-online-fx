package com.goyobo.sqlonline.utils

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView

fun fontIcon(icon: FontAwesomeIcon, size: Number = 14.0) =
    FontAwesomeIconView(icon).apply { glyphSize = size }

fun fontIcon(icon: MaterialDesignIcon, size: Number = 18.0) =
    MaterialDesignIconView(icon).apply { glyphSize = size }