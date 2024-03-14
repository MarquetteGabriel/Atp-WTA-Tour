package fr.gmarquette.atpwtatour.model.players

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Profile(
    var name : String,
    var firstName : String,
    var profilePicture : Bitmap,
    var age : Float,
    var birthDate: Date,
    var birthPlace: String,
    var nationality: String,
    var height : Int,
    var weight : Int,
    var plays: Plays,
    var backhand: Plays,
    var career: Career,
    var rank : Rank,
    var coach: String
)
{
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    fun setAge(age: Float) {
        this.age = age
    }

    fun setBirthDate(birthDate: Date?) {
        this.birthDate = birthDate!!
    }

    fun setBirthPlace(birthPlace: String?) {
        this.birthPlace = birthPlace!!
    }

    fun setHeight(height: Int) {
        this.height = height
    }

    fun setWeight(weight: Int) {
        this.weight = weight
    }

    fun setCoach(coach: String?) {
        this.coach = coach!!
    }
}