package com.example.ecampus.data.models.groupsModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GroupsApiModel (

    @SerializedName("id") @Expose
    val id: Int? = null,
    @SerializedName("name") @Expose
    val name: String? = null,
    @SerializedName("eduLevel") @Expose
    val eduLevel: String? = null,
    @SerializedName("year") @Expose
    val year: Int? = null,

        )