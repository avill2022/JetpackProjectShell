package avill.ladv.shellcompose.domain

import avill.ladv.shellcompose.data.Repository
import avill.ladv.shellcompose.data.model.PopularPuppies
import javax.inject.Inject

class GetPuppiesByBreed @Inject constructor(private val repository:Repository){
    //is a function that invoque when we used the call to class
    //suspend operator fun invoke(): MutableLiveData<PopularPuppies> = repository.getPuppiesByBreed()
    suspend fun getPuppies(breed:String):PopularPuppies?{
        return repository.getPuppiesByBreed("breed/$breed/images/random/10")
    }
}