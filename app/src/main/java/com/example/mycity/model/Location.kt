package com.example.mycity.model

import android.location.Address
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Location(
    @StringRes val name: Int,
    val category: Category,
    @StringRes val description: Int,
    val address: Address,
    @DrawableRes val image: Int
    )
