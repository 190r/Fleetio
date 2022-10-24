package com.fleetio.di

import com.fleetio.common.BASE_URL
import com.fleetio.domain.repository.AuthInterceptor
import com.fleetio.domain.repository.VehicleFleetApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

//    @Provides
//    @Singleton
//    fun providesVehicleRepository(retrofitClient: Retrofit)


    @Provides
    @Singleton
    fun providesRetrofitClient(okHttpClient: OkHttpClient): VehicleFleetApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VehicleFleetApi::class.java)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient() = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()
}