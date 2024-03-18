package fr.gmarquette.atpwtatour.model.season.matches

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import fr.gmarquette.atpwtatour.model.season.Matches
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MatchesViewModel(application: Application): AndroidViewModel(application) {

    private val repository: MatchesRepository

    init {
        val matchesDAO = MatchesDatabase.getDatabase(application).matchesDAO()
        repository = MatchesRepository(matchesDAO)
    }

    fun addMatch(match: Matches) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMatch(match)
        }
    }

    fun getMatchesByTournament(tournament: String): LiveData<List<Matches>> {
        return repository.getMatchesByTournament(tournament)
    }

    fun getMatchesByPlayer(player: String): LiveData<List<Matches>> {
        return repository.getMatchesByPlayer(player)
    }
}