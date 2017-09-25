package org.mautokar.movieapp.util

import android.support.v7.app.AppCompatActivity
import org.mautokar.movieapp.App


val AppCompatActivity.app: App
    get() = application as App


val Byte.booleanValue: Boolean
    get() = this.toInt() != 0
