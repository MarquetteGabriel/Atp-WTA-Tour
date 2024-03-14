package fr.gmarquette.atpwtatour.model.season

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Tournament (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var level : Level,
    var date : Date,
    var surface : Surfaces,
    var prize : Int,
    var location : String,
    var draws : List<Matches>,
    var yearOfCreation : Int,
    var pastChampions : List<String>
)
{

}