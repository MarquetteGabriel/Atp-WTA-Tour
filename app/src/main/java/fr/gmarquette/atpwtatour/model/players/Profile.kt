package fr.gmarquette.atpwtatour.model.players

import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.gmarquette.atpwtatour.Category

@Entity(tableName = "profile_table")
data class Profile(
    var category: Category,
    var name : String,
    var firstName : String,
    var profilePicture : String,
    var age : Int,
    var birthDate: String,
    var birthPlace: String,
    var nationality: String,
    var height : String,
    var weight : String,
    var plays: Plays,
    var backhand: Plays,
    var turnedPro: Int,
    var career: Career,
    var rank : Rank,
    var coach: String
)
{

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    var codeID: String = ""
    var fullName: String = ""

    init {
        fullName = firstName + " " + name
    }
    constructor(category: Category, name: String, firstName: String) : this(category, name,
        firstName, "",0, "", "", "", "", "",
        Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(), "")

    constructor() : this(Category.ATP, "", "", "", 0, "", "", "", "", "",
        Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(), "")

    constructor(name: String, firstName: String, nationality: String) : this(Category.ATP, name, firstName, "", 0, "", "", nationality, "", "",
        Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(), "")
}