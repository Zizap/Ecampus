package com.example.ecampus.data.dataSourceIMPL

import android.util.Log
import com.example.ecampus.data.api.ApiClient
import com.example.ecampus.data.dataSource.ScheduleApiDataSource
import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScheduleApiDataSourceIMPL:ScheduleApiDataSource {

    override fun getSchedule(
        specialties: GetScheduleModel,
        onSuccess: (ScheduleApiModel) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        var data: ScheduleApiModel?
        val call = ApiClient.instanse?.api?.getSchedule(specialties)
        call?.enqueue(object : Callback<ScheduleApiModel> {

            override fun onResponse(
                call: Call<ScheduleApiModel>,
                response: Response<ScheduleApiModel>
            ) {
                if (response.isSuccessful) {
                    data = response.body()
                    Log.e("ProverimWEEEK","${data?.weekdays.toString()}")
                    data?.let { onSuccess(it) } ?: onError(Throwable("Empty response"))
                }

            }

            override fun onFailure(call: Call<ScheduleApiModel>, t: Throwable) {

            }
        })
    }

}