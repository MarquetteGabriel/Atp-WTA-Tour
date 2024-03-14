package fr.gmarquette.atpwtatour.model.players

import fr.gmarquette.atpwtatour.model.season.Matches

class Career
{
    var rank: Rank? = null
    var matches: List<Matches>? = null
    var trophies = 0
    var turnedPro = 0
    var prizeMoney = 0
    var wins = 0
    var looses = 0
}