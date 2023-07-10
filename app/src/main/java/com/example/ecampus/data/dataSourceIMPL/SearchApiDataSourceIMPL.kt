package com.example.ecampus.data.dataSourceIMPL

import android.util.Log
import com.example.ecampus.data.api.ApiClient
import com.example.ecampus.data.dataSource.SearchApiDataSource
import com.example.ecampus.data.models.getModels.GetSearchModel
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel
import com.example.ecampus.data.models.searchModel.SearchApiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchApiDataSourceIMPL:SearchApiDataSource {

    override fun search(
        searchModel: GetSearchModel,
        onSuccess: (SearchApiModel) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        var data: SearchApiModel?
        val call = ApiClient.instanse?.api?.search(searchModel)
        call?.enqueue(object : Callback<SearchApiModel>{

            override fun onResponse(
                call: Call<SearchApiModel>,
                response: Response<SearchApiModel>
            ) {
                Log.e("DataSourceIMPL","Начал работу")
                if (response.isSuccessful) {
                    Log.e("DataSourceIMPL","isSuccessful Начал работу")
                    data = response.body()
                    Log.e("ProverimSearch","${response.body().toString()}")
                    data?.let { onSuccess(it) } ?: onError(Throwable("Empty response"))
                } else {
                    Log.e("ОШИБКА ПОЛУЧЕНИЯ ДАННЫХ","ОШИБКА")
                }
            }

            override fun onFailure(call: Call<SearchApiModel>, t: Throwable) {

            }

        })
    }

}