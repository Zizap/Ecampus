package com.example.ecampus.data.repository

import com.example.ecampus.data.dataSource.SpecialtiesApiDataSource
import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesApiModel
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.domain.repository.SpecialtiesCall

class SpecialtiesRepository(private val specialtiesApiDataSource: SpecialtiesApiDataSource):SpecialtiesCall {

    override fun getSpecialties(
        specialties: GetSpecialtiesModel,
        onSuccess: (ArrayList<SpecialtiesApiModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        specialtiesApiDataSource.getSpecialties(specialties,onSuccess,onError)
    }


}