package com.example.ecampus.domain.useCase

import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.domain.repository.GroupsCall

class GroupsUseCase(private val groupsCall: GroupsCall) {

    fun getGroups(
        specialties: GetSpecialtiesModel,
        onSuccess: (ArrayList<GroupsApiModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        groupsCall.getGroups(specialties,onSuccess,onError)
    }

}