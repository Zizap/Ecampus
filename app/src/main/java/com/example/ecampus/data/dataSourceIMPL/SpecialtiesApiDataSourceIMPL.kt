package com.example.ecampus.data.dataSourceIMPL

import android.util.Log
import com.example.ecampus.data.api.ApiClient
import com.example.ecampus.data.dataSource.SpecialtiesApiDataSource
import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesApiModel
import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesList
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpecialtiesApiDataSourceIMPL:SpecialtiesApiDataSource {

    override fun getSpecialties(
        specialties: GetSpecialtiesModel,
        onSuccess: (ArrayList<SpecialtiesApiModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val data = ArrayList<SpecialtiesApiModel>()
        val call = ApiClient.instanse?.api?.getSpecialties(specialties)
        call?.enqueue(object :Callback<SpecialtiesList> {
            override fun onResponse(
                call: Call<SpecialtiesList>,
                response: Response<SpecialtiesList>
            ) {
                if (response.isSuccessful) {
                    response.body()?.forEach { item ->
                        data.add(item)
                    }
                    data.let { onSuccess(it) } ?: onError(Throwable("Empty response"))
                }
            }

            override fun onFailure(call: Call<SpecialtiesList>, t: Throwable) {

            }

        })

    }

}


