package com.example.greatestalbumapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Albums(
    val album_name: String,
    val detail_album_desc: String,
    val release_date: String,
    val album_photo: Int
) : Parcelable
