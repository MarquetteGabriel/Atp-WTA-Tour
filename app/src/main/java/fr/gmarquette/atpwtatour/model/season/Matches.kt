package fr.gmarquette.atpwtatour.model.season

import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.gmarquette.atpwtatour.model.players.Profile
import fr.gmarquette.atpwtatour.model.statistics.Stats

@Entity(tableName = "matches_table")
data class Matches(
    val playerOne: Profile,
    val playerTwo: Profile,
    val round: Rounds,
    val date: String,
    val duration: Int, // in minutes
    val score: Score,
    val statistics: Stats,
    val tournamentName: String
)
{

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    var seriePlayerOne: String = ""
    var seriePlayerTwo: String = ""

    constructor() : this (
        Profile(), Profile(), Rounds.QUALIFIER, "", 0, Score(), Stats(), ""
    )

    constructor(playerOne: Profile, playerTwo: Profile, round: Rounds, duration: Int, score: Score, tournamentName: String) : this (
        playerOne, playerTwo, round, "", duration, score, Stats(), tournamentName
    )
}