package com.goyobo.sqlonline.utils

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView

fun fontIcon(icon: FontAwesomeIcon, size: Number = 14.0) =
    FontAwesomeIconView(icon).apply { glyphSize = size }