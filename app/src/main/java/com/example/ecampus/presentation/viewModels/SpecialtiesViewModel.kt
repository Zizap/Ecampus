package com.example.ecampus.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecampus.data.dataSource.InstitutesApiDataSource
import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesApiModel
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.domain.useCase.SpecialtiesUseCase

class SpecialtiesViewModel(private val specialtiesUseCase: SpecialtiesUseCase): ViewModel() {

    private val _specialties = MutableLiveData<ArrayList<SpecialtiesApiModel>>()
    val specialties: LiveData<ArrayList<SpecialtiesApiModel>> get() = _specialties

    fun loadSpecialties(getSpecialtiesModel: GetSpecialtiesModel){
        specialtiesUseCase.getSpecialties(
            specialties = getSpecialtiesModel,
            onSuccess = {
                    data -> _specialties.value = data
            },
            onError = {

            }
        )
    }

}