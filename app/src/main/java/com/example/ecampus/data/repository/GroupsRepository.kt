package com.example.ecampus.data.repository

import com.example.ecampus.data.dataSource.GroupsApiDataSource
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.domain.repository.GroupsCall

class GroupsRepository(private val groupsApiDataSource: GroupsApiDataSource):GroupsCall {


    override fun getGroups(
        specialties: GetSpecialtiesModel,
        onSuccess: (ArrayList<GroupsApiModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        groupsApiDataSource.getGroups(specialties,onSuccess,onError)
    }


}