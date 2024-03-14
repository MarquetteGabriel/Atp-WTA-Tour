package fr.gmarquette.atpwtatour.model.players

import java.util.Date

class Rank
{
    var currentRank = 0
    var bestRank = 0
    var points = 0
    var liveRank = 0
    var rankByWeek: HashMap<Date, Int>? = null
}