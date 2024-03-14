package fr.gmarquette.atpwtatour.model.season.tournament

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fr.gmarquette.atpwtatour.model.season.Tournament

@Dao
interface TournamentDAO
{
    @Insert
    suspend fun addTournament(tournament: Tournament)

    @Query("SELECT * FROM tournament")
    fun getTournaments(): LiveData<List<Tournament>>
}