package com.example.ecampus.data.repository

import com.example.ecampus.data.dataSource.PairTimesApiDataSource
import com.example.ecampus.data.models.pairTimesModels.PairTimesApiModule
import com.example.ecampus.domain.repository.PairTimesCall

class PairTimesRepository(private val pairTimesApiDataSource: PairTimesApiDataSource):PairTimesCall {

    override fun getPairTimes(
        onSuccess: (ArrayList<PairTimesApiModule>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        pairTimesApiDataSource.getPairTimes(onSuccess,onError)
    }

}