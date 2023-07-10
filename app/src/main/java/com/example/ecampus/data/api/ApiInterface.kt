package com.example.ecampus.data.api

import com.example.ecampus.data.models.institutesModels.InstitutesList
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesList
import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.getModels.GetSearchModel
import com.example.ecampus.data.models.groupsModel.GroupsList
import com.example.ecampus.data.models.pairTimesModels.PairTimesList
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel
import com.example.ecampus.data.models.searchModel.SearchApiModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("Schedule/GetInstitutes")
    fun getInstitutes(): Call<InstitutesList>

    @POST("Schedule/GetSpecialties")
    fun getSpecialties(@Body specialties: GetSpecialtiesModel): Call<SpecialtiesList>

    @POST("Schedule/GetGroups")
    fun getGroups(@Body specialties: GetSpecialtiesModel): Call<GroupsList>

    @POST("Schedule/GetPairTimes")
    fun getPairTimes(): Call<PairTimesList>

    @POST("Schedule/GetGroupSchedule")
    fun getSchedule(@Body specialties: GetScheduleModel): Call<ScheduleApiModel>

    @POST("Schedule/Search")
    fun search(@Body search: GetSearchModel): Call<SearchApiModel>


}