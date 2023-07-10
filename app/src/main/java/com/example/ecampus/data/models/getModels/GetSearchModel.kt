package com.example.ecampus.data.models.getModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetSearchModel (
    @SerializedName("query") @Expose
    val query: String? = null,
    @SerializedName("pageSize") @Expose
    val pageSize: Int? = null,
    @SerializedName("type") @Expose
    val type: Int? = null,
    @SerializedName("page") @Expose
    val page: Int? = null,
        )
