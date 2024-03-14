package fr.gmarquette.atpwtatour.model.season

import fr.gmarquette.atpwtatour.model.players.Profile
import fr.gmarquette.atpwtatour.model.statistics.Stats
import java.time.LocalDateTime

data class Matches(
    val playerOne: Profile,
    val playerTwo: Profile,
    val arbitre: String,
    val round: Rounds,
    val stadium: String,
    val date: LocalDateTime,
    val alreadyPlayed: Boolean,
    val duration: Int, // in minutes
    val score: Score,
    val statistics: Stats
)
{
    fun isAlreadyPlayed(date: LocalDateTime): Boolean
    {
        return date.isAfter((LocalDateTime.now()));
    }
}