package com.example.ecampus.data.dataSourceIMPL


import android.util.Log
import com.example.ecampus.data.api.ApiClient
import com.example.ecampus.data.dataSource.InstitutesApiDataSource
import com.example.ecampus.data.models.institutesModels.InstitutesApiModel
import com.example.ecampus.data.models.institutesModels.InstitutesList
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesApiModel
import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesList
import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.data.models.groupsModel.GroupsList
import com.example.ecampus.data.models.pairTimesModels.PairTimesApiModule
import com.example.ecampus.data.models.pairTimesModels.PairTimesList
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InstitutesApiDataSourceIMPL():InstitutesApiDataSource {


    override fun getInstitutes(
        onSuccess: (ArrayList<InstitutesApiModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val data = ArrayList<InstitutesApiModel>()
        val call = ApiClient.instanse?.api?.getInstitutes()
        call?.enqueue(object :Callback<InstitutesList> {
            override fun onResponse(
                call: Call<InstitutesList>,
                response: Response<InstitutesList>
            ) {
                if (response.isSuccessful) {
                    response.body()?.forEach{ item ->
                        data.add(item)
                    }
                    data.let { onSuccess(it) } ?: onError(Throwable("Empty response"))
                }
                else{
                }
            }
            override fun onFailure(call: Call<InstitutesList>, t: Throwable) {
            }
        })
    }




}