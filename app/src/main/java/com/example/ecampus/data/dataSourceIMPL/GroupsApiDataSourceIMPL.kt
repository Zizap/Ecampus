package com.example.ecampus.data.dataSourceIMPL

import android.util.Log
import com.example.ecampus.data.api.ApiClient
import com.example.ecampus.data.dataSource.GroupsApiDataSource
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.data.models.groupsModel.GroupsList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GroupsApiDataSourceIMPL:GroupsApiDataSource {

    override fun getGroups(
        specialties: GetSpecialtiesModel,
        onSuccess: (ArrayList<GroupsApiModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val data = ArrayList<GroupsApiModel>()
        val call = ApiClient.instanse?.api?.getGroups(specialties)
        call?.enqueue(object : Callback<GroupsList> {
            override fun onResponse(
                call: Call<GroupsList>,
                response: Response<GroupsList>
            ) {
                if (response.isSuccessful) {
                    response.body()?.forEach { item ->
                        data.add(item)
                        Log.e("Proverim","${item.toString()}")
                    }
                    data.let { onSuccess(it) } ?: onError(Throwable("Empty response"))
                }
            }

            override fun onFailure(call: Call<GroupsList>, t: Throwable) {

            }

        })
    }

}