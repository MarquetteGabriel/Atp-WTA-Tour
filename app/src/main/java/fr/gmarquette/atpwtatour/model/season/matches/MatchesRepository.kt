package fr.gmarquette.atpwtatour.model.season.matches

import androidx.lifecycle.LiveData
import fr.gmarquette.atpwtatour.model.season.Matches

class MatchesRepository (private val matchesDAO: MatchesDAO) {

    suspend fun addMatch(match: Matches) {
        matchesDAO.addMatch(match)
    }

    fun getMatchesByTournament(tournament: String): LiveData<List<Matches>> {
        return matchesDAO.getMatchesByTournament(tournament)
    }

    fun getMatchesByPlayer(player: String): LiveData<List<Matches>> {
        return matchesDAO.getMatchesByPlayer(player)
    }

    fun getMatchesByDate(date: String): LiveData<List<Matches>> {
        return matchesDAO.getMatchesByDate(date)
    }
}