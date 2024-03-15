package fr.gmarquette.atpwtatour.model.players

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class Profile(
    var name : String,
    var firstName : String,
    // var profilePicture : Bitmap,
    var age : Float,
    // var birthDate: Date,
    var birthPlace: String,
    var nationality: String,
    var height : Int,
    var weight : Int,
    var plays: Plays,
    var backhand: Plays,
    //var career: Career,
    //var rank : Rank,
    var coach: String
)
{
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}