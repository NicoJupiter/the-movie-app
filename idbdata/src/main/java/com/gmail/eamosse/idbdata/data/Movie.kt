package com.gmail.eamosse.idbdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val id:Int, val title:String, val poster_path:String) : Parcelable