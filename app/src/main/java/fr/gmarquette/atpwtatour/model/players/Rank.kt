package fr.gmarquette.atpwtatour.model.players

import java.util.Date

class Rank
{
    var currentRank: Int = 0
    var previousRank: Int = 0
    var bestRank: Int = 0
    var points: Int = 0
    var liveRank: Int = 0
    var previousLiveRank: Int = 0
    var racePoints: Int = 0
    var raceRank: Int = 0
    var previousRaceRank: Int = 0
    var rankByWeek: HashMap<Date, Int>? = null

    constructor() {
        this.currentRank = 0
        this.previousRank = 0
        this.bestRank = 0
        this.points = 0
        this.liveRank = 0
        this.previousLiveRank = 0
        this.racePoints = 0
    }
    constructor(
        currentRank: Int,
        previousRank: Int,
        bestRank: Int,
        points: Int,
        liveRank: Int,
        previousLiveRank: Int,
        racePoints: Int
    ) {
        this.currentRank = currentRank
        this.previousRank = previousRank
        this.bestRank = bestRank
        this.points = points
        this.liveRank = liveRank
        this.previousLiveRank = previousLiveRank
        this.racePoints = racePoints
    }


    fun getRankUpdate(previousRank: Int, currentRank: Int): String
    {
        val updatedRank = currentRank - previousRank

        return if(updatedRank > 0) {
            "+" + updatedRank
        } else if (updatedRank == 0) {
            ""
        } else {
            updatedRank.toString()
        }
    }
}