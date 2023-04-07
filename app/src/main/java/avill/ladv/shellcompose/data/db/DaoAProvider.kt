package avill.ladv.shellcompose.data.db

import avill.ladv.shellcompose.data.model.PuppyDB
import kotlinx.coroutines.flow.Flow

interface DaoAProvider{
    fun getPuppyDB(): Flow<List<PuppyDB>>

    suspend fun insertFavorite(puppy: PuppyDB)
    suspend fun deletePuppyByUrl(puppy: PuppyDB)

    suspend fun getPuppyById(id:Int): PuppyDB?
    suspend fun getAllSavedPuppy() : Flow<List<PuppyDB>>
}
/*
import androidx.lifecycle.LiveData
import avill.ladv.examplemvvm.data.model.PuppyDB
import avill.ladv.shellcompose.data.db.MyDao
import javax.inject.Inject

class DaoAService @Inject constructor(
    private val dao: MyDao
):

    (private val dogDaoRoom: DaoRoom) {
    val dogList: LiveData<List<PuppyDB>> = dogDaoRoom.getAllSavedPuppy()

    suspend fun insertFavoritePuppy(dog: PuppyDB) {
        dogDaoRoom.insertFavorite(dog)
    }

    suspend fun getDogById(dogId: String): PuppyDB {
        return dogDaoRoom.getPuppyById(dogId)
    }
    suspend fun getDogByUrl(dogUrl: String): PuppyDB {
        return dogDaoRoom.getPuppyByUrl(dogUrl)
    }

    suspend fun deleteDogById(dogId: String) {
        dogDaoRoom.deletePuppyById(dogId)
    }

    suspend fun deleteDogByUrl(dogUrl: String) {
        dogDaoRoom.deletePuppyByUrl(dogUrl)
    }

    suspend fun deleteDog(dog: PuppyDB) = dogDaoRoom.deletePuppy(dog)
}*/