package com.example.ecampus.data.models.pairTimesModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PairTimesApiModule (

    @SerializedName("name") @Expose
    val name: String? = null,
    @SerializedName("hourStart") @Expose
    val hourStart: Int? = null,
    @SerializedName("minuteStart") @Expose
    val minuteStart: Int? = null,
    @SerializedName("hourEnd") @Expose
    val hourEnd: Int? = null,
    @SerializedName("minuteEnd") @Expose
    val minuteEnd: Int? = null,
    @SerializedName("duration") @Expose
    val duration: Int? = null,
    @SerializedName("startTime") @Expose
    val startTime: String? = null,
    @SerializedName("endTime") @Expose
    val endTime: String? = null,
    @SerializedName("isCurrent") @Expose
    val isCurrent: Boolean? = null,
    @SerializedName("displayed") @Expose
    val displayed: Boolean? = null,

        )
