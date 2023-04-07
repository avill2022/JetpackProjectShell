package avill.ladv.shellcompose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import avill.ladv.shellcompose.data.model.PuppyDB

@Database(
    entities = [PuppyDB::class],
    version = 1,
    exportSchema = false
)
abstract class DaoDatabase : RoomDatabase() {
    abstract val daoRoom:DaoRoom
}

