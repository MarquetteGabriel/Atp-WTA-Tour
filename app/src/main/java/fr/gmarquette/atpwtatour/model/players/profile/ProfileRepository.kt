package fr.gmarquette.atpwtatour.model.players.profile

import androidx.lifecycle.LiveData
import fr.gmarquette.atpwtatour.Category
import fr.gmarquette.atpwtatour.model.players.Profile

class ProfileRepository (private val profileDAO: ProfileDAO)
{

    val getProfiles: LiveData<List<Profile>> = profileDAO.getProfiles()
    val getATPProfiles: LiveData<List<Profile>> = profileDAO.getATPProfiles(Category.ATP)

    suspend fun addProfile(profile: Profile) {
        profileDAO.addProfile(profile)
    }

    fun getProfile(name: String, firstName: String): LiveData<Profile> {
        return profileDAO.getProfile(name, firstName)
    }

}