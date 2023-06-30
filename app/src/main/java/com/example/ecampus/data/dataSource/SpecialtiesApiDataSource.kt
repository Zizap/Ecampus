package com.example.ecampus.data.dataSource

import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesApiModel
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel

interface SpecialtiesApiDataSource {

    fun getSpecialties(specialties: GetSpecialtiesModel,
                       onSuccess: (ArrayList<SpecialtiesApiModel>) -> Unit,
                       onError: (Throwable) -> Unit
    )

}