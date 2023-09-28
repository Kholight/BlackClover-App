package com.example.myapp_submission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Karakter(
    val name: String,
    val status: String,
    val description: String,
    val photo: String
) : Parcelable