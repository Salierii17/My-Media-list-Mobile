package com.example.mymedialistapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaData(
    val title: String,
    val description: String,
    val cover: String
) : Parcelable
