package com.example.ecampus.data.dataSourceIMPL

import android.util.Log
import com.example.ecampus.data.api.ApiClient
import com.example.ecampus.data.dataSource.PairTimesApiDataSource
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.data.models.pairTimesModels.PairTimesApiModule
import com.example.ecampus.data.models.pairTimesModels.PairTimesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PairTimesApiDataSourceIMPL:PairTimesApiDataSource{

    override fun getPairTimes(
        onSuccess: (ArrayList<PairTimesApiModule>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val data = ArrayList<PairTimesApiModule>()
        val call = ApiClient.instanse?.api?.getPairTimes()
        call?.enqueue(object :Callback<PairTimesList> {

            override fun onResponse(
                call: Call<PairTimesList>,
                response: Response<PairTimesList>
            ) {
                if (response.isSuccessful) {
                    response.body()?.forEach { item ->
                        data.add(item)
                    }
                    data.let { onSuccess(it) } ?: onError(Throwable("Empty response"))
                }
            }
            override fun onFailure(
                call: Call<PairTimesList>,
                t: Throwable
            ) {
            }

        })
    }

}