package com.example.submission3.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tv (
    var id : Int,
    var tvName : String,
    var tvDesc : String,
    var tvScore : String,
    var tvRelease : String,
    var tvPoster : String

)  : Parcelable

