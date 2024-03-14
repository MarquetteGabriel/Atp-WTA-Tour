package fr.gmarquette.atpwtatour.model.players

import fr.gmarquette.atpwtatour.model.season.Level
import fr.gmarquette.atpwtatour.model.season.Rounds
import fr.gmarquette.atpwtatour.model.season.Tournament
import java.util.Date

class Points
{
    var date: Date? = null
    var tournament: Tournament? = null
    var round: Rounds? = null // Surement possible via le tournoi lui-même

    var pts: Level? = null
    var dropDate: Date? = null
}