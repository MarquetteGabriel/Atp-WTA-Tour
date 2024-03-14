package fr.gmarquette.atpwtatour.model

import androidx.lifecycle.LiveData
import fr.gmarquette.atpwtatour.model.players.Profile

class ProfileRepository (private val profileDAO: ProfileDAO)
{

    val getProfiles: LiveData<List<Profile>> = profileDAO.getProfiles()
    val getProfile: LiveData<Profile> = profileDAO.getProfile("name", "firstName")

    suspend fun addProfile(profile: Profile) {
        profileDAO.addProfile(profile)
    }

}