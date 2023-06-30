package com.example.ecampus.data.dataSource

import com.example.ecampus.data.models.SpecialtiesModels.SpecialtiesApiModel
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.pairTimesModels.PairTimesApiModule

interface PairTimesApiDataSource {

    fun getPairTimes(onSuccess: (ArrayList<PairTimesApiModule>) -> Unit,
                     onError: (Throwable) -> Unit
    )


}