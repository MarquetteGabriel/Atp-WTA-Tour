package fr.gmarquette.atpwtatour.view.scores

import fr.gmarquette.atpwtatour.model.season.Matches

sealed class MatchData
{
    data class Item(val match: Matches) : MatchData()
    data class Header(val tournamentName: String) : MatchData()
}