package fr.gmarquette.atpwtatour.model.season.tournament

import androidx.lifecycle.LiveData
import fr.gmarquette.atpwtatour.model.season.Tournament

class TournamentRepository (private val tournamentDAO: TournamentDAO)
{

    val getTournaments: LiveData<List<Tournament>> = tournamentDAO.getTournaments()

    suspend fun addProfile(tournament: Tournament) {
        tournamentDAO.addTournament(tournament)
    }

}