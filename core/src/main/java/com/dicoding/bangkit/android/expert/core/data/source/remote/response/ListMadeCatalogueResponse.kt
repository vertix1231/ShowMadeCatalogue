package com.dicoding.bangkit.android.expert.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMadeCatalogueResponse(

    @SerializedName("error")
    val error:Boolean,

    @SerializedName("message")
    val message:String,

    @SerializedName("places")
    val places:List<MadeCatalogueResponse>
)