package avill.ladv.shellcompose.domain.crud_db

import avill.ladv.shellcompose.data.db.DaoAProvider
import avill.ladv.shellcompose.data.model.PuppyDB
import javax.inject.Inject

class InsertPuppy @Inject constructor(private val daoService: DaoAProvider) {
    suspend operator fun invoke(puppy: PuppyDB){
        daoService.deletePuppyByUrl(puppy)
    }
}