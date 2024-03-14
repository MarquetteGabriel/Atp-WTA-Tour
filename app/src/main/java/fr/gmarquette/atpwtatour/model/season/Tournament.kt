package fr.gmarquette.atpwtatour.model.season

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Tournament (
    var level : Level,
    var name : String,
    var picture: Bitmap,
    var date : Date,
    var surface : Surfaces,
    var prize : Int,
    var location : String,
    var drawSize: Int,
    var draws : List<Matches>,
    var yearOfCreation : Int,
    var pastChampions : List<String>
)
{
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

}