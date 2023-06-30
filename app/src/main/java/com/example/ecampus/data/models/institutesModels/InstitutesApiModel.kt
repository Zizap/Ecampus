package com.example.ecampus.data.models.institutesModels

import android.util.Log
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data class InstitutesApiModel(

    @SerializedName("id") @Expose
    val id: Int? = null,
    @SerializedName("name") @Expose
    val name: String? = null,
    @SerializedName("shortName") @Expose
    val shortName: String? = null,
    @SerializedName("branchId") @Expose
    val branchId: Int? = null,
    )

