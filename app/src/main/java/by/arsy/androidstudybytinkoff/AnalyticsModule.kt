package by.arsy.androidstudybytinkoff

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule {

    @Provides
    fun provideTag(): String {
        return "AnalyticsTag"
    }

    @Provides
    @ActivityScoped
    fun provideAnalytics(tag: String): Analytics {
        return AnalyticsImpl(tag)
    }
}