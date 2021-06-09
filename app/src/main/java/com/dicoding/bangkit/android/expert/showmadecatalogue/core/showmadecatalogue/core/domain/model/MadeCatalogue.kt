package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MadeCatalogue(
    val tourismId: String,
    val name: String,
    val description: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val like: Int,
    val image: String,
    val isFavorite: Boolean,
):Parcelable