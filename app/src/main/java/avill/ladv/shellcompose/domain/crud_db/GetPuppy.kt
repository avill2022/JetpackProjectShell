package avill.ladv.shellcompose.domain.crud_db

import avill.ladv.shellcompose.data.db.DaoAProvider
import avill.ladv.shellcompose.data.model.PuppyDB
import javax.inject.Inject

class GetPuppy @Inject constructor(private val daoService: DaoAProvider) {
    suspend operator fun invoke(puppy: Int):PuppyDB?{
        return daoService.getPuppyById(puppy)
    }
}