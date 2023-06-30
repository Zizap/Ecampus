package com.example.ecampus.data.dataSource

import com.example.ecampus.data.models.institutesModels.InstitutesApiModel
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesApiModel
import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.groupsModel.GroupsApiModel
import com.example.ecampus.data.models.pairTimesModels.PairTimesApiModule
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel


interface InstitutesApiDataSource {

    fun getInstitutes(onSuccess: (ArrayList<InstitutesApiModel>) -> Unit,
                      onError: (Throwable) -> Unit
    )






}
