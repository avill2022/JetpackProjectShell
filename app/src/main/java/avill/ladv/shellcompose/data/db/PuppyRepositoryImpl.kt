package avill.ladv.shellcompose.data.db

import avill.ladv.shellcompose.data.model.PuppyDB
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PuppyRepositoryImpl @Inject constructor(private val dao:DaoRoom) : DaoAProvider {
    override fun getPuppyDB(): Flow<List<PuppyDB>> {
        return dao.getAllSavedPuppy()
    }

    override suspend fun insertFavorite(puppy: PuppyDB) {
         return dao.insertFavorite(puppy)
    }

    override suspend fun deletePuppyByUrl(puppy: PuppyDB) {
         return dao.deletePuppyByUrl(puppy)
    }

    override suspend fun getPuppyById(id: Int): PuppyDB? {
         return dao.getPuppyById(id)
    }

    override suspend fun getAllSavedPuppy(): Flow<List<PuppyDB>> {
         return dao.getAllSavedPuppy()
    }

}