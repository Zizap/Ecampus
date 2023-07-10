package com.example.ecampus.data.models.searchModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchApiModel (

    @SerializedName("teachers") @Expose
    val teachers: DataForSearch,
    @SerializedName("rooms") @Expose
    val rooms: DataForSearch,
    @SerializedName("groups") @Expose
    val groups: DataForSearch,
    @SerializedName("fullList") @Expose
    val fullList: List<ListEntity>

)

data class ListEntity(
    @SerializedName("items") @Expose
    val items: List<DataForSearch>,
    @SerializedName("count") @Expose
    val count: Int,
    @SerializedName("entity") @Expose
    val entity: Int
)

data class DataForSearch(
    @SerializedName("id") @Expose
    val id: Int,
    @SerializedName("name") @Expose
    val name: String,
    @SerializedName("parentId") @Expose
    val parentId: Int?
)



