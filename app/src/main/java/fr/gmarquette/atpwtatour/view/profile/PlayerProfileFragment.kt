package fr.gmarquette.atpwtatour.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.gmarquette.atpwtatour.R
import fr.gmarquette.atpwtatour.databinding.FragmentPlayerProfileBinding
import fr.gmarquette.atpwtatour.model.players.Plays
import fr.gmarquette.atpwtatour.model.players.Profile
import fr.gmarquette.atpwtatour.model.players.flags.Flags
import fr.gmarquette.atpwtatour.model.players.profile.ProfileViewModel

class PlayerProfileFragment : Fragment() {

    private var menuList: List<String> = listOf("Overview", "Stats", "Results")
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var binding: FragmentPlayerProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player_profile, container, false)
        val view = binding.root

        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        // TODO: Get the player from the database
        val player = Profile("Sinner", "Jannik", 22.0F, "", "Italy", 185, 75, Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, "Riccardo Piatti")
        //var player = profileViewModel.getProfile("Sinner", "Jannik").value as Profile


        // Top of the page
        val playerName: TextView = view.findViewById(R.id.nameTextView)
        val playerPicture: ImageView = view.findViewById(R.id.profilePictureImageView)
        val playerNationality: ImageView = view.findViewById(R.id.nationalityProfileImageView)
        val playerRank: TextView = view.findViewById(R.id.rankTextView)

        playerName.text = player.name
        //playerPicture.setImageBitmap(player.profilePicture)
        Flags.getFlag(player.nationality, playerNationality, this.requireContext())
        //playerRank.text = player.rank.currentRank.toString()

        // Middle Page
        val recyclerView: RecyclerView = view.findViewById(R.id.playerProfileRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = PlayerProfileAdapter(menuList) {
            val playerProfileOverviewLayout = view.findViewById(R.id.playerProfileOverview) as View
            val playerProfileStatsLayout = view.findViewById(R.id.playerProfileStats) as View
            val playerProfileResultsLayout = view.findViewById(R.id.playerProfileResults) as View

            when (it) {
                "Overview" -> {
                    playerProfileOverviewLayout.visibility = View.VISIBLE
                    playerProfileStatsLayout.visibility = View.GONE
                    playerProfileResultsLayout.visibility = View.GONE
                }
                "Stats" -> {
                    playerProfileOverviewLayout.visibility = View.GONE
                    playerProfileStatsLayout.visibility = View.VISIBLE
                    playerProfileResultsLayout.visibility = View.GONE
                }
                "Results" -> {
                    playerProfileOverviewLayout.visibility = View.GONE
                    playerProfileStatsLayout.visibility = View.GONE
                    playerProfileResultsLayout.visibility = View.VISIBLE
                }
            }
        }


        // Bottom of the page
        // Overview
        val playerAge: TextView = view.findViewById(R.id.playerAgeText)
        val playerBirthPlace: TextView = view.findViewById(R.id.playerBirthplaceText)
        val playerHeight: TextView = view.findViewById(R.id.playerHeightText)
        val playerWeight: TextView = view.findViewById(R.id.playerWeightText)
        val playerPlays: TextView = view.findViewById(R.id.playerPlaysText)
        val playerBackhand: TextView = view.findViewById(R.id.playerBackhandText)
        val playerCoach: TextView = view.findViewById(R.id.playerCoachText)

        playerAge.text = player.age.toString()
        playerBirthPlace.text = player.birthPlace
        playerHeight.text = player.height.toString()
        playerWeight.text = player.weight.toString()
        playerPlays.text = player.plays.description
        playerBackhand.text = player.backhand.description
        playerCoach.text = player.coach

        return view
    }
}