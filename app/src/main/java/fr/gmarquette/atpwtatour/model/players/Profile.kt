package fr.gmarquette.atpwtatour.model.players

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class Profile(
    var name : String,
    var firstName : String,
    // var profilePicture : Bitmap,
    var age : Int,
    var birthDate: String,
    var birthPlace: String,
    var nationality: String,
    var height : String,
    var weight : String,
    var plays: Plays,
    var backhand: Plays,
    var turnedPro: Int,
    //var career: Career,
    //var rank : Rank,
    var coach: String
)
{
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}