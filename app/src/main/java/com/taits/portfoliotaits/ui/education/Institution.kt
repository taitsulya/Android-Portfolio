package com.taits.fifthapplication.ui.contacts

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Institution(
    val title: String,
    @DrawableRes val imageInstitution: Int
) : Parcelable