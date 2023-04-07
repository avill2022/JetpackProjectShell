package avill.ladv.shellcompose.data.apis

import avill.ladv.shellcompose.data.model.BreedPuppy
import avill.ladv.shellcompose.data.model.PopularPuppies
import avill.ladv.shellcompose.data.model.Puppy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class APIService  @Inject constructor(
    private val retrofit:PuppyApi
){


    suspend fun getRandomPuppy(): Puppy {
        return withContext(Dispatchers.IO) {
            val response: Response<Puppy> = retrofit.getRandomDog()
            (if(response.isSuccessful)
                response.body()
            else
                response.body())!!
        }
    }

    suspend fun getPopularPuppies(): PopularPuppies{
        return withContext(Dispatchers.IO) {
            val response: Response<PopularPuppies> = retrofit.getPopularPuppies()
            (if(response.isSuccessful)
                response.body()
            else
                response.body())!!
        }
    }

    suspend fun getBread(s:String): BreedPuppy {
        return withContext(Dispatchers.IO) {
            val response: Response<BreedPuppy> = retrofit.getPuppyByBreed(s)
            (if(response.isSuccessful)
                response.body()
            else
                response.body())!!
        }
    }

    suspend fun getPuppiesByBreed(breed:String): PopularPuppies {
        return withContext(Dispatchers.IO) {
            val response: Response<PopularPuppies> = retrofit.getPuppiesByBreed(breed)
            (if(response.isSuccessful)
                response.body()
            else
                response.body())!!
        }
    }
}