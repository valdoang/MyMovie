package com.dicoding.mymovie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val name: String,
    val director: String,
    val writer: String,
    val network: String,
    val episodes: String,
    val released_date: String,
    val synopsis: String,
    val photo: String
) :Parcelable
