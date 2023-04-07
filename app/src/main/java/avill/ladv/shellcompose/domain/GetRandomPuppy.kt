package avill.ladv.shellcompose.domain

import avill.ladv.shellcompose.core.isnull
import avill.ladv.shellcompose.data.Repository
import avill.ladv.shellcompose.data.model.PopularPuppies
import avill.ladv.shellcompose.data.model.Puppy
import javax.inject.Inject

class GetRandomPuppy @Inject constructor(private val repository:Repository){
    suspend fun getRandomDog(): Puppy?{
        val example:Puppy? = repository.getRandomPuppy()
        if(!example.isnull()){
           // val randomNumber:Int = (example.indices).random()
            return example//[randomNumber]
        }
        return null
    }
}