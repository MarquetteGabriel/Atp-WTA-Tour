package fr.gmarquette.atpwtatour.model.players.profile

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fr.gmarquette.atpwtatour.model.players.Profile

@Dao
interface ProfileDAO
{
    @Insert
    suspend fun addProfile(profile: Profile)

    @Query("SELECT * FROM profile")
    fun getProfiles(): LiveData<List<Profile>>

    @Query("SELECT * FROM profile WHERE name = :name AND firstName = :firstName")
    fun getProfile(name: String, firstName: String): LiveData<Profile>
}