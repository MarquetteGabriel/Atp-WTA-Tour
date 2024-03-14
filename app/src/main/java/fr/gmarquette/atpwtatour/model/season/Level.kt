package fr.gmarquette.atpwtatour.model.season

class Level
{
    private val level: TournamentCategory? = null
    private var pointsByRank: HashMap<TournamentCategory, HashMap<Rounds, Int>>? = null

    init {
        pointsByRank = HashMap()
        pointsByRank()
    }

    fun getPointsByRank(tournamentLevel: TournamentCategory, round: Rounds): Int? {
        return if (pointsByRank!!.containsKey(tournamentLevel) && pointsByRank!![tournamentLevel]!!.containsKey(
                round
            )
        ) {
            pointsByRank!![tournamentLevel]!![round]
        } else 0
    }

    fun pointsByRank() {
        for (tournamentCategory in TournamentCategory.entries) {
            val pointsByRounds = HashMap<Rounds, Int>()
            when (tournamentCategory) {
                TournamentCategory.JO, TournamentCategory.ATP_250 -> {
                    pointsByRounds[Rounds.QUALIFIER] = 0
                    pointsByRounds[Rounds.R128] = 0
                    pointsByRounds[Rounds.R64] = 0
                    pointsByRounds[Rounds.R32] = 0
                    pointsByRounds[Rounds.R16] = 25
                    pointsByRounds[Rounds.QUARTER_FINALS] = 50
                    pointsByRounds[Rounds.SEMI_FINALS] = 100
                    pointsByRounds[Rounds.FINALS] = 165
                    pointsByRounds[Rounds.WINNER] = 250
                    pointsByRank!![tournamentCategory] = pointsByRounds
                }

                TournamentCategory.ATP_500 -> {
                    pointsByRounds[Rounds.QUALIFIER] = 0
                    pointsByRounds[Rounds.R128] = 0
                    pointsByRounds[Rounds.R64] = 0
                    pointsByRounds[Rounds.R32] = 0
                    pointsByRounds[Rounds.R16] = 50
                    pointsByRounds[Rounds.QUARTER_FINALS] = 100
                    pointsByRounds[Rounds.SEMI_FINALS] = 200
                    pointsByRounds[Rounds.FINALS] = 330
                    pointsByRounds[Rounds.WINNER] = 500
                }

                TournamentCategory.ATP_1000 -> {
                    pointsByRounds[Rounds.QUALIFIER] = 0
                    pointsByRounds[Rounds.R128] = 0
                    pointsByRounds[Rounds.R64] = 10
                    pointsByRounds[Rounds.R32] = 50
                    pointsByRounds[Rounds.R16] = 100
                    pointsByRounds[Rounds.QUARTER_FINALS] = 200
                    pointsByRounds[Rounds.SEMI_FINALS] = 400
                    pointsByRounds[Rounds.FINALS] = 650
                    pointsByRounds[Rounds.WINNER] = 1000
                }

                TournamentCategory.ATP_GRAND_CHELEM -> {
                    pointsByRounds[Rounds.QUALIFIER] = 30
                    pointsByRounds[Rounds.R128] = 10
                    pointsByRounds[Rounds.R64] = 50
                    pointsByRounds[Rounds.R32] = 100
                    pointsByRounds[Rounds.R16] = 200
                    pointsByRounds[Rounds.QUARTER_FINALS] = 400
                    pointsByRounds[Rounds.SEMI_FINALS] = 800
                    pointsByRounds[Rounds.FINALS] = 1300
                    pointsByRounds[Rounds.WINNER] = 2000
                    pointsByRank!![tournamentCategory] = pointsByRounds
                }

                TournamentCategory.ATP_FINALS, TournamentCategory.DAVIS_CUP, TournamentCategory.WTA_125, TournamentCategory.WTA_250, TournamentCategory.WTA_500, TournamentCategory.WTA_1000, TournamentCategory.WTA_GRAND_CHELEM, TournamentCategory.WTA_FINALS -> {}
                else -> {}
            }
        }
    }
}