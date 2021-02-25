package com.example.androiddevchallenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cat(
    val name: String,
    val picture: Int,
    val from: String,
) : Parcelable