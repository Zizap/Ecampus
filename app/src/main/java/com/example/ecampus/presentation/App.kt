package com.example.ecampus.presentation

import android.app.Application
import com.example.ecampus.presentation.di.groupsDI
import com.example.ecampus.presentation.di.institutesDI
import com.example.ecampus.presentation.di.pairTimesDI
import com.example.ecampus.presentation.di.scheduleDI
import com.example.ecampus.presentation.di.searchDI
import com.example.ecampus.presentation.di.specialtiesDI
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(institutesDI,
                groupsDI,
                specialtiesDI,
                pairTimesDI,
                scheduleDI,
                searchDI)
        }
    }

}