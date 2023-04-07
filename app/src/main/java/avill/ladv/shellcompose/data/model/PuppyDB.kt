package avill.ladv.shellcompose.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "puppy_information")
data class PuppyDB(
    @PrimaryKey(autoGenerate = true)
    val puppyId: Int,
    val image: String,
    val breed:String
)
