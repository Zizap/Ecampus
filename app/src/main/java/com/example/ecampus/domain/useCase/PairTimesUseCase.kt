package com.example.ecampus.domain.useCase

import com.example.ecampus.data.models.pairTimesModels.PairTimesApiModule
import com.example.ecampus.domain.repository.PairTimesCall

class PairTimesUseCase(private val pairTimesCall:PairTimesCall) {

     fun getPairTimes(
        onSuccess: (ArrayList<PairTimesApiModule>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        pairTimesCall.getPairTimes(onSuccess,onError)
    }

}