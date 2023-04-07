package avill.ladv.shellcompose.data.db
import androidx.lifecycle.LiveData
import androidx.room.*
import avill.ladv.shellcompose.data.model.PuppyDB
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoRoom {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(puppy: PuppyDB)

    @Delete
    fun deletePuppyByUrl(puppy: PuppyDB)

    @Query("SELECT * FROM puppy_information WHERE puppyId =:id")
    fun getPuppyById(id:Int):PuppyDB?

    @Query("SELECT * FROM puppy_information order by puppyId asc")
    fun getAllSavedPuppy(): Flow<List<PuppyDB>>

/*@Query("SELECT * FROM puppy_information WHERE puppyId =:id")
fun getPuppyById(id:String):PuppyDB
@Insesuspend fun insertMyEntity(myEntity: PuppyDB)

@Insert
fun insertFavorite(puppy: PuppyDB)

@Update
fun updateFavorite(puppy: PuppyDB)*/

/* @Query("SELECT * FROM puppy_information order by puppyId asc")
fun getAllSavedPuppy():LiveData<List<PuppyDB>>

@Query("SELECT * FROM puppy_information WHERE puppyId =:id")
fun getPuppyById(id:String):PuppyDB

@Query("SELECT * FROM puppy_information WHERE image =:url")
fun getPuppyByUrl(url:String):PuppyDB

@Query("SELECT * FROM puppy_information WHERE image =:url")
fun getPuppyByUr(url:String):PuppyDB

@Query("DELETE FROM puppy_information WHERE puppyId =:id")
fun deletePuppyById(id:String)

@Query("DELETE FROM puppy_information WHERE image =:url")
fun deletePuppyByUrl(url:String)

@Delete
fun deletePuppy(puppy:PuppyDB)*/
}