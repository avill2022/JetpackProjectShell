package avill.ladv.shellcompose.domain

import avill.ladv.shellcompose.core.isnull
import avill.ladv.shellcompose.data.Repository
import avill.ladv.shellcompose.data.model.PopularPuppies
import javax.inject.Inject

class GetPopularPuppies @Inject constructor(private val repository:Repository){
    //is a function that invoque when we used the call to class
    //val getExampalesUseCase = GetExampleUseCase
    //getExampleUseCase() // then the function invoke is call
    /* operator fun invoke():List<String>?
    {
        return repository.getByName("akita")
    }
    suspend fun getPetByName(name:String):List<String>?{
        return repository.getByName(name)
    }*/
    suspend fun getGetPopularPuppies(): PopularPuppies? {
        val example:PopularPuppies? = repository.getPopularPuppies()
        if(!example.isnull()){
            // val randomNumber:Int = (example.indices).random()
            return example//[randomNumber]
        }
        return null
    }
}