package fr.gmarquette.atpwtatour.model.season

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tournament_table")
data class Tournament (
    var category : TournamentCategory,
    var name : String,
    //var picture: Bitmap,
    var date : String,
    var surface : Surfaces,
    var io: Surfaces,
    var prize : Int,
    var location : String,
    var drawSize: Int,
    var yearOfCreation : Int,
    var pastChampions : List<String>,
    var tournamentMonth: Int
)
{

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    lateinit var draws : List<Matches>

    constructor(category: TournamentCategory, name: String, date: String, surface: Surfaces, io: Surfaces, prize: Int, location: String, drawSize: Int) : this (
        category,name, date, surface, io, prize, location, drawSize, 0, emptyList(), 0
    )

    fun setTournamentMonth(month: String) : Int
    {
        return if(month.contains("jan")) 1
        else if(month.contains("feb")) 2
        else if(month.contains("mar")) 3
        else if(month.contains("apr")) 4
        else if(month.contains("may")) 5
        else if(month.contains("jun")) 6
        else if(month.contains("jul")) 7
        else if(month.contains("aug")) 8
        else if(month.contains("sep")) 9
        else if(month.contains("oct")) 10
        else if(month.contains("nov")) 11
        else 12
    }


}