package com.pedrosoares.injectionmvvmlib.services

import android.app.Application
import android.content.Context
import android.support.annotation.NonNull
import com.pedrosoares.injectionmvvmlib.interfaces.DialogService
import com.pedrosoares.injectionmvvmlib.interfaces.SharedPreferencesService
import dagger.Module
import dagger.Provides
import com.pedrosoares.injectionmvvmlib.interfaces.NavigationService
import javax.inject.Singleton

@Module
class SimpleServicesModule {

    @Provides
    @NonNull
    @Singleton
    public fun providesContext(app: Application): Context = app.applicationContext

    @Provides
    @NonNull
    @Singleton
    public fun providesDialogService(context: Context, activityTracker: CurrentActivityTracker): DialogService {
        return SimpleDialogService(context, activityTracker)
    }

    @Provides
    @NonNull
    @Singleton
    public fun providesNavigationService(context: Context, activityTracker: CurrentActivityTracker): NavigationService {
        return SimpleNavigationService(context, activityTracker)
    }


    @Provides
    @NonNull
    @Singleton
    public fun providesSharedPreferences(context: Context): SharedPreferencesService {
        return SimpleSharedPreferencesService(context)
    }
}