package avill.ladv.shellcompose.di

import android.app.Application
import androidx.room.Room
import avill.ladv.shellcompose.data.Repository
import avill.ladv.shellcompose.data.apis.APIService
import avill.ladv.shellcompose.data.apis.PuppyApi
import avill.ladv.shellcompose.data.db.DaoAProvider
import avill.ladv.shellcompose.data.db.DaoDatabase
import avill.ladv.shellcompose.data.db.PuppyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/*
SingletonComponent
Application
ViewModel
Activity
Fragment
View
Views
* */

@Module
@InstallIn(SingletonComponent::class)//live as long the app live
object AppModule {
    @Provides
    fun provideMyDatabase(@ApplicationContext application:Application)= Room.databaseBuilder(
            application,
            DaoDatabase::class.java, "my_database"
        ).build()

    @Provides
    @Singleton
    fun provideMyDatabase(daoDatabase: DaoDatabase): DaoAProvider {
        return PuppyRepositoryImpl(daoDatabase.daoRoom)
    }

    @Provides
    @Singleton//create the same instance as long the application live
    fun providePuppyApi(): PuppyApi {
        val puppyApiBreads: PuppyApi by lazy {
            Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PuppyApi::class.java)
        }
        return puppyApiBreads
    }
    @Provides
    @Singleton
    @Named("apiService")
    fun provideRepositoryInterface(): APIService {
        return APIService(providePuppyApi())
    }

    /*@Provides
    @Singleton
    @Named("Bd")
    fun provideDaoRoom(application: Application): DaoDatabase {
        synchronized(this){
            return Room.databaseBuilder(
                application,
                DaoDatabase::class.java,
                "database"
            ).build()
        }
    }*/

    /*@Provides
    @Singleton
    @Named("daoService")
    fun provideDaoService(daoDatabase: DaoDatabase): DaoAService {
        return DaoAService(daoDatabase.dao())
    }*/
    @Provides
    @Singleton
    @Named("repository")
    fun provideRepository(api:APIService,dao:DaoAProvider): Repository {
       return Repository(dao,api)
    }
}