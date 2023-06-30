package com.example.ecampus.data.models.getModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetScheduleModel (

    @SerializedName("Id") @Expose
    val Id: Int? = null,
    @SerializedName("Name") @Expose
    val Name: Int? = null,
    @SerializedName("ParentId") @Expose
    val ParentId: Int? = null,

)