package fr.gmarquette.atpwtatour.model.season.tournament

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import fr.gmarquette.atpwtatour.model.season.Tournament
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TournamentViewModel(application: Application): AndroidViewModel(application)
{
    private val getTournaments: LiveData<List<Tournament>>
    private val repository: TournamentRepository

    init {
        val profileDAO = TournamentDataBase.getDatabase(application).tournamentDAO()
        repository = TournamentRepository(profileDAO)
        getTournaments = repository.getTournaments
    }

    fun addProfile(tournament: Tournament) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTournament(tournament)
        }
    }

    fun getTournaments(): LiveData<List<Tournament>> {
        return getTournaments
    }


}