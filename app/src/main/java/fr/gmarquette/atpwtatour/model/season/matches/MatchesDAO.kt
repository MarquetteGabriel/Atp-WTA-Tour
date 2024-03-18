package fr.gmarquette.atpwtatour.model.season.matches

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fr.gmarquette.atpwtatour.model.season.Matches

@Dao
interface MatchesDAO {

    @Insert
    suspend fun addMatch(match: Matches)

    @Query("SELECT * FROM matches_table WHERE tournamentName = :tournament")
    fun getMatchesByTournament(tournament: String): LiveData<List<Matches>>

    @Query("SELECT * FROM matches_table WHERE playerOne = :player OR playerTwo = :player")
    fun getMatchesByPlayer(player: String): LiveData<List<Matches>>
}