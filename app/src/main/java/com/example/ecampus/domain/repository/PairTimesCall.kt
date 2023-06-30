package com.example.ecampus.domain.repository

import com.example.ecampus.data.models.pairTimesModels.PairTimesApiModule

interface PairTimesCall {

    fun getPairTimes(onSuccess: (ArrayList<PairTimesApiModule>) -> Unit,
                     onError: (Throwable) -> Unit
    )

}