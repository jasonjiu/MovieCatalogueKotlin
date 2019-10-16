package com.example.submission3.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var movieId : Int,
    var movieName : String,
    var movieDesc : String,
    var movieScore : String,
    var movieRelease : String,
    var moviePoster : String
) : Parcelable