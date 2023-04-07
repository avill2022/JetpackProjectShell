package avill.ladv.shellcompose.data

import android.app.Application
import avill.ladv.shellcompose.data.apis.APIService
import avill.ladv.shellcompose.data.db.DaoAProvider
import avill.ladv.shellcompose.data.model.*
import java.net.UnknownHostException
import javax.inject.Inject

//access to bd or network
class Repository@Inject constructor(
    private val daoDatabase: DaoAProvider,
    private val api: APIService
):Application() {
    companion object {
        var randomPuppy: Puppy? = null
        var popularPuppies: PopularPuppies? = null
        var puppiesByBreedsRandom:ArrayList<Breed> = arrayListOf()
        var breedList:ArrayList<Breed> = arrayListOf()
    }
    suspend fun getDbPuppy(): PuppyDB? {
        return try {
            daoDatabase.getPuppyById(1)
        } catch(e: UnknownHostException) {
            null
        }
    }
    suspend fun getRandomPuppy(): Puppy? {
        return try {
            api.getRandomPuppy()
        } catch(e: UnknownHostException) {
            null
        }
    }
    suspend fun getPopularPuppies():PopularPuppies?{
        return try {
            api.getPopularPuppies()
        } catch(e: UnknownHostException) {
            null
        }
    }
    suspend fun getPuppyByBreed(name:String): BreedPuppy? {
        return try {
            api.getBread(name)
        } catch(e: UnknownHostException) {
            null
        }
     }
    suspend fun getPuppiesByBreed(breed:String): PopularPuppies? {
        return try {
            api.getPuppiesByBreed(breed)
        } catch(e: UnknownHostException) {
            null
        }
    }
}