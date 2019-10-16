package com.example.moviecataloguekotlin.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tv (
    var tvName : String,
    var tvDesc : String,
    var tvScore : String,
    var tvRelease : String,
    var tvPoster : String
)  : Parcelable

