package com.example.ecampus.domain.useCase

import com.example.ecampus.data.models.getModels.GetScheduleModel
import com.example.ecampus.data.models.scheduleModel.ScheduleApiModel
import com.example.ecampus.domain.repository.ScheduleCall

class ScheduleUseCase(private val scheduleCall: ScheduleCall) {

     fun getSchedule(
        specialties: GetScheduleModel,
        onSuccess: (ScheduleApiModel) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        scheduleCall.getSchedule(specialties,onSuccess,onError)
    }

}