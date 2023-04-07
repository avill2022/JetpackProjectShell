package avill.ladv.shellcompose.domain.crud_db

import avill.ladv.shellcompose.data.db.DaoAProvider
import avill.ladv.shellcompose.data.model.PuppyDB
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPuppies @Inject constructor(private val daoService: DaoAProvider) {
    suspend operator fun invoke(): Flow<List<PuppyDB>> {
        return daoService.getAllSavedPuppy()
    }
}