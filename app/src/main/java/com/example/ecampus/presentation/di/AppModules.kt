package com.example.ecampus.presentation.di


import com.example.ecampus.data.dataSource.GroupsApiDataSource
import com.example.ecampus.data.dataSource.InstitutesApiDataSource
import com.example.ecampus.data.dataSource.PairTimesApiDataSource
import com.example.ecampus.data.dataSource.ScheduleApiDataSource
import com.example.ecampus.data.dataSource.SearchApiDataSource
import com.example.ecampus.data.dataSource.SpecialtiesApiDataSource
import com.example.ecampus.data.dataSourceIMPL.GroupsApiDataSourceIMPL
import com.example.ecampus.data.dataSourceIMPL.InstitutesApiDataSourceIMPL
import com.example.ecampus.data.dataSourceIMPL.PairTimesApiDataSourceIMPL
import com.example.ecampus.data.dataSourceIMPL.ScheduleApiDataSourceIMPL
import com.example.ecampus.data.dataSourceIMPL.SearchApiDataSourceIMPL
import com.example.ecampus.data.dataSourceIMPL.SpecialtiesApiDataSourceIMPL
import com.example.ecampus.data.repository.GroupsRepository
import com.example.ecampus.data.repository.InstituteRepository
import com.example.ecampus.data.repository.PairTimesRepository
import com.example.ecampus.data.repository.ScheduleRepository
import com.example.ecampus.data.repository.SearchRepository
import com.example.ecampus.data.repository.SpecialtiesRepository
import com.example.ecampus.domain.repository.GroupsCall
import com.example.ecampus.domain.repository.InstitutesCall
import com.example.ecampus.domain.repository.PairTimesCall
import com.example.ecampus.domain.repository.ScheduleCall
import com.example.ecampus.domain.repository.SearchCall
import com.example.ecampus.domain.repository.SpecialtiesCall
import com.example.ecampus.domain.useCase.GroupsUseCase
import com.example.ecampus.domain.useCase.InstituteUseCase
import com.example.ecampus.domain.useCase.PairTimesUseCase
import com.example.ecampus.domain.useCase.ScheduleUseCase
import com.example.ecampus.domain.useCase.SearchUseCase
import com.example.ecampus.domain.useCase.SpecialtiesUseCase
import com.example.ecampus.presentation.viewModels.GroupsViewModel
import com.example.ecampus.presentation.viewModels.InstitutesViewModel
import com.example.ecampus.presentation.viewModels.PairTimesViewModel
import com.example.ecampus.presentation.viewModels.ScheduleViewModel
import com.example.ecampus.presentation.viewModels.SearchViewModel
import com.example.ecampus.presentation.viewModels.SpecialtiesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val institutesDI = module {


    single<InstitutesApiDataSource> { InstitutesApiDataSourceIMPL() }

    single<InstitutesCall> { InstituteRepository(get()) }

    single { InstituteUseCase(get()) }

    viewModel { InstitutesViewModel(get()) }

}

val specialtiesDI = module {


    single<SpecialtiesApiDataSource> { SpecialtiesApiDataSourceIMPL() }

    single<SpecialtiesCall> { SpecialtiesRepository(get()) }

    single { SpecialtiesUseCase(get()) }

    viewModel { SpecialtiesViewModel(get()) }

}

val groupsDI = module {


    single<GroupsApiDataSource> { GroupsApiDataSourceIMPL() }

    single<GroupsCall> { GroupsRepository(get()) }

    single { GroupsUseCase(get()) }

    viewModel { GroupsViewModel(get()) }

}

val pairTimesDI = module {


    single<PairTimesApiDataSource> { PairTimesApiDataSourceIMPL() }

    single<PairTimesCall> { PairTimesRepository(get()) }

    single { PairTimesUseCase(get()) }

    viewModel { PairTimesViewModel(get()) }

}


val scheduleDI = module {


    single<ScheduleApiDataSource> { ScheduleApiDataSourceIMPL() }

    single<ScheduleCall> { ScheduleRepository(get()) }

    single { ScheduleUseCase(get()) }

    viewModel { ScheduleViewModel(get()) }

}

val searchDI = module {

    single<SearchApiDataSource> { SearchApiDataSourceIMPL() }

    single<SearchCall> { SearchRepository(get()) }

    single { SearchUseCase(get()) }

    viewModel{ SearchViewModel(get()) }

}
