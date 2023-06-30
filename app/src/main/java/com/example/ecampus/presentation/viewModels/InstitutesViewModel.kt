package com.example.ecampus.presentation.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecampus.data.dataSource.InstitutesApiDataSource
import com.example.ecampus.data.models.institutesModels.InstitutesApiModel
import com.example.ecampus.domain.useCase.InstituteUseCase


class InstitutesViewModel(private val instituteUseCase: InstituteUseCase): ViewModel() {

    private val _institutes = MutableLiveData<ArrayList<InstitutesApiModel>>()
    val institutes: LiveData<ArrayList<InstitutesApiModel>> get() = _institutes

    fun loadInstitutes(){
        instituteUseCase.getInstitutes(
            onSuccess = {
                    data -> _institutes.value = data
            },
            onError = {

            }
        )
    }
}