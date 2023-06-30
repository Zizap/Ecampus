package com.example.ecampus.domain.repository

import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel

interface GroupsCall {

    fun getGroups(
        specialties: GetSpecialtiesModel,
        onSuccess: (ArrayList<GroupsApiModel>) -> Unit,
        onError: (Throwable) -> Unit
    )

}