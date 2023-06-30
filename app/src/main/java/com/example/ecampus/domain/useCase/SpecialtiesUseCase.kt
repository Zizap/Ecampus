package com.example.ecampus.domain.useCase

import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesApiModel
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.domain.repository.SpecialtiesCall

class SpecialtiesUseCase(private val specialtiesCall: SpecialtiesCall) {

     fun getSpecialties(
        specialties: GetSpecialtiesModel,
        onSuccess: (ArrayList<SpecialtiesApiModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        specialtiesCall.getSpecialties(specialties,onSuccess,onError)
    }

}