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
    var draws : List<Matches>,
    var yearOfCreation : Int,
    var pastChampions : List<String>,
    var tournamentMonth: String
)
{
    constructor(category: TournamentCategory, name: String, date: String, surface: Surfaces, io: Surfaces, prize: Int, location: String, drawSize: Int) : this (
        category,name, date, surface, io, prize, location, drawSize, emptyList(), 0, emptyList(), ""
    )

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0


}