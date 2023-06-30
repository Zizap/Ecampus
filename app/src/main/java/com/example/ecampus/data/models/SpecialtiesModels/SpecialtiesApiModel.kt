package com.example.ecampus.data.models.SpecialtiesModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SpecialtiesApiModel (

    @SerializedName("items") @Expose
    val items: Int? = null,
    @SerializedName("id") @Expose
    val id: Int? = null,
    @SerializedName("name") @Expose
    val name: String? = null,
    @SerializedName("parentId") @Expose
    val parentId: Int? = null,

    )

