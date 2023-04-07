package avill.ladv.shellcompose.domain

import avill.ladv.shellcompose.core.isnull
import avill.ladv.shellcompose.data.Repository
import avill.ladv.shellcompose.data.model.Breed
import avill.ladv.shellcompose.data.model.BreedPuppy
import avill.ladv.shellcompose.data.model.PopularPuppies
import javax.inject.Inject


class GetPuppyByBreeds @Inject constructor(private val repository:Repository){
    var breedList:ArrayList<Breed> = arrayListOf()

    suspend fun getPuppy(breed:String): Breed? {
        val example: BreedPuppy? = repository.getPuppyByBreed("breed/$breed/images/random")
        if(!example.isnull()){
            if (example != null) {
                return Breed(example.message,breed)
            }//[randomNumber]
        }
        return null
    }
}