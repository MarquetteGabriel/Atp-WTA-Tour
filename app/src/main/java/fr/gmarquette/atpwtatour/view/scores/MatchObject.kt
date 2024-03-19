package fr.gmarquette.atpwtatour.view.scores

import fr.gmarquette.atpwtatour.model.players.Profile
import fr.gmarquette.atpwtatour.model.season.Matches
import fr.gmarquette.atpwtatour.model.season.Rounds
import fr.gmarquette.atpwtatour.model.season.Score
import fr.gmarquette.atpwtatour.model.season.matches.MatchesViewModel
import java.time.LocalDate

object MatchObject
{
    const val MATCH_ITEM = 0
    const val MATCH_HEADER = 1

    fun getItems(matchesViewModel: MatchesViewModel, date: LocalDate) : ArrayList<Any> {
        val itemList = arrayListOf<Any>()

        // val matches = matchesViewModel.getMatchesByDate(date)
        val matches = mutableListOf<Matches>()
        val sinner = Profile("Sinner", "Jannik", "Italy")
        val rafa = Profile("Nadal", "Rafael", "Spain")
        val mensik = Profile("Mensik", "Jakub", "Czechia")
        val cazaux = Profile("Cazaux", "Arthur", "France")
        val novak = Profile("Djokovic", "Novak", "Serbia")

        matches.add(Matches(sinner, rafa, Rounds.FINALS, 167,
            Score("6-4", "6-7 5", "4 7-6", "6-2", "12 7-6"), "Roland Garros"))
        matches.add(Matches(mensik, cazaux, Rounds.QUARTER_FINALS, 215,
            Score("6-4", "6-1", "6-4"), "Roland Garros"))
        matches.add(Matches(rafa, novak, Rounds.SEMI_FINALS, 167,
            Score("6-4", "6-7 5", "4 7-6", "6-2", "12 7-6"), "US Open"))
        matches.add(Matches(mensik, cazaux, Rounds.QUARTER_FINALS, 215,
            Score("6-4", "6-1", "6-4"), "US Open"))
        matches.add(Matches(rafa, novak, Rounds.SEMI_FINALS, 167,
            Score("6-4", "6-7 5", "4 7-6", "6-2", "12 7-6"), "Australian Open"))
        matches.add(Matches(mensik, cazaux, Rounds.QUARTER_FINALS, 215,
            Score("6-4", "6-1", "6-4"), "Australian Open"))
        matches.add(Matches(rafa, novak, Rounds.SEMI_FINALS, 167,
            Score("6-4", "6-7 5", "4 7-6", "6-2", "12 7-6"), "Wimbledon"))
        matches.add(Matches(mensik, cazaux, Rounds.QUARTER_FINALS, 215,
            Score("6-4", "6-1", "6-4"), "Wimbledon"))
        matches.add(Matches(rafa, novak, Rounds.SEMI_FINALS, 167,
            Score("4-6", "6-7 5", "4 7-6", "2-6", "12 7-6"), "Roland Garros"))


        matches.sortBy { it.tournamentName }
        for (match in matches) {
            val tournamentName = match.tournamentName

            val headerExist = itemList.any { it is MatchData.Header && it.tournamentName == tournamentName }
            if(!headerExist) {
                itemList.add(MatchData.Header(tournamentName))
            }
            itemList.add(MatchData.Item(match))
        }

        //TODO : get items

        return itemList
    }
}