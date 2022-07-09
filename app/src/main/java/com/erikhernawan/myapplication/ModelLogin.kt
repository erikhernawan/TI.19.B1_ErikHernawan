package com.erikhernawan.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ModelLogin(
    val username: String,
    var password: String,
) : Parcelable
