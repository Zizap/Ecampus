package com.example.ecampus.data.dataSource

import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.data.models.pairTimesModels.PairTimesApiModule

interface GroupsApiDataSource {

    fun getGroups(specialties: GetSpecialtiesModel,
                  onSuccess: (ArrayList<GroupsApiModel>) -> Unit,
                  onError: (Throwable) -> Unit
    )


}