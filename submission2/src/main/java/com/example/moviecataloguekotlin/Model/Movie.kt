package com.example.moviecataloguekotlin.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var movieName : String,
    var movieDesc : String,
    var movieScore : String,
    var movieRelease : String,
    var moviePoster : String

) : Parcelable