package com.example.sportcars

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cars(
    val name: String,
    val description: String,
    val photo: Int,
    val sound: String
) : Parcelable
