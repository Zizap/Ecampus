package com.example.ecampus.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecampus.data.dataSource.InstitutesApiDataSource
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.data.models.pairTimesModels.PairTimesApiModule
import com.example.ecampus.domain.useCase.PairTimesUseCase

class PairTimesViewModel(private val pairTimesUseCase: PairTimesUseCase): ViewModel() {

    private val _pairTimes = MutableLiveData<ArrayList<PairTimesApiModule>>()
    val pairTimes: LiveData<ArrayList<PairTimesApiModule>> get() = _pairTimes

    fun loadPairTimes(getSpecialtiesModel: GetSpecialtiesModel){
        pairTimesUseCase.getPairTimes(
            onSuccess = {
                    data -> _pairTimes.value = data
            },
            onError = {

            }
        )
    }

}