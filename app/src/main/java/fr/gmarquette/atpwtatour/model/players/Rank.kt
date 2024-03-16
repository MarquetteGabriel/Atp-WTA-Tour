package fr.gmarquette.atpwtatour.model.players

import java.util.Date

class Rank
{
    var currentRank: Int = 0
    var previousRank: Int = 0
    var bestRank: Int = 0
    var points: Int = 0
    var liveRank: Int = 0
    var rankByWeek: HashMap<Date, Int>? = null
}