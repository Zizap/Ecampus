package com.example.ecampus.data.models.getModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetSpecialtiesModel (
    @SerializedName("BranchId") @Expose
    val BranchId: Int? = null,
    @SerializedName("InstituteId") @Expose
    val InstituteId: Int? = null,
    @SerializedName("DepartmentId") @Expose
    val DepartmentId: Int? = null,
        )