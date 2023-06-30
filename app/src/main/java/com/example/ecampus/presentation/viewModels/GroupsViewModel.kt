package com.example.ecampus.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecampus.data.dataSource.InstitutesApiDataSource
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.domain.useCase.GroupsUseCase

class GroupsViewModel(private val groupsUseCase: GroupsUseCase): ViewModel() {

    private val _groups = MutableLiveData<ArrayList<GroupsApiModel>>()
    val groups: LiveData<ArrayList<GroupsApiModel>> get() = _groups

    fun loadGroups(getSpecialtiesModel: GetSpecialtiesModel){
        groupsUseCase.getGroups(
            specialties = getSpecialtiesModel,
            onSuccess = {
                    data -> _groups.value = data
            },
            onError = {

            }
        )
    }

}