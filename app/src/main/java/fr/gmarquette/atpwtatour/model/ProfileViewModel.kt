package fr.gmarquette.atpwtatour.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import fr.gmarquette.atpwtatour.model.players.Profile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application): AndroidViewModel(application)
{
    private val getProfiles: LiveData<List<Profile>>
    private val getProfile: LiveData<Profile>
    private val repository: ProfileRepository

    init {
        val profileDAO = ProfileDataBase.getDatabase(application).profileDAO()
        repository = ProfileRepository(profileDAO)
        getProfiles = repository.getProfiles
        getProfile = repository.getProfile
    }

    fun addProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProfile(profile)
        }
    }

    fun getProfiles(): LiveData<List<Profile>> {
        return getProfiles
    }

    fun getProfile(): LiveData<Profile> {
        return getProfile
    }

}