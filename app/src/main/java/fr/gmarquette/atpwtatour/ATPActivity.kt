package fr.gmarquette.atpwtatour

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import fr.gmarquette.atpwtatour.databinding.ActivityAtpBinding
import fr.gmarquette.atpwtatour.view.scores.ScoresFragmentDirections

class ATPActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityAtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navComponentATP) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.matchesMenu -> {
                    when (navController.currentDestination?.id) {
                        R.id.leaderboardFragment -> navController.navigate(R.id.action_leaderboardFragment_to_scoresFragment)
                        R.id.calendarFragment -> navController.navigate(R.id.action_calendarFragment_to_scoresFragment)
                        R.id.favoritesFragment -> navController.navigate(R.id.action_favoritesFragment_to_scoresFragment)

                        R.id.playerProfileFragment -> navController.navigate(R.id.action_playerProfileFragment_to_scoresFragment)
                        R.id.tournamentProfilFragment -> navController.navigate(R.id.action_tournamentProfilFragment_to_scoresFragment)
                        R.id.matchFragment -> navController.navigate(R.id.action_matchFragment_to_scoresFragment)
                    }
                }
                R.id.calendarMenu -> {
                    when (navController.currentDestination?.id) {
                        R.id.leaderboardFragment -> navController.navigate(R.id.action_leaderboardFragment_to_calendarFragment)
                        R.id.scoresFragment -> navController.navigate(ScoresFragmentDirections.actionScoresFragmentToCalendarFragment("Roger Federer"))
                        R.id.favoritesFragment -> navController.navigate(R.id.action_favoritesFragment_to_calendarFragment)

                        R.id.tournamentProfilFragment -> navController.navigate(R.id.action_tournamentProfilFragment_to_calendarFragment)
                        R.id.matchFragment -> navController.navigate(R.id.action_matchFragment_to_calendarFragment)
                        R.id.playerProfileFragment -> navController.navigate(R.id.action_playerProfileFragment_to_calendarFragment)
                    }
                }
                R.id.rankMenu -> {
                    when (navController.currentDestination?.id) {
                        R.id.scoresFragment -> navController.navigate(R.id.action_scoresFragment_to_leaderboardFragment)
                        R.id.calendarFragment -> navController.navigate(R.id.action_calendarFragment_to_leaderboardFragment)
                        R.id.favoritesFragment -> navController.navigate(R.id.action_favoritesFragment_to_leaderboardFragment)

                        R.id.tournamentProfilFragment -> navController.navigate(R.id.action_tournamentProfilFragment_to_leaderboardFragment)
                        R.id.matchFragment -> navController.navigate(R.id.action_matchFragment_to_leaderboardFragment)
                        R.id.playerProfileFragment -> navController.navigate(R.id.action_playerProfileFragment_to_leaderboardFragment)
                    }
                }
                R.id.favMenu -> {
                    when (navController.currentDestination?.id) {
                        R.id.leaderboardFragment -> navController.navigate(R.id.action_leaderboardFragment_to_favoritesFragment)
                        R.id.scoresFragment -> navController.navigate(R.id.action_scoresFragment_to_favoritesFragment)
                        R.id.calendarFragment -> navController.navigate(R.id.action_calendarFragment_to_favoritesFragment)

                        R.id.playerProfileFragment -> navController.navigate(R.id.action_playerProfileFragment_to_favoritesFragment)
                        R.id.tournamentProfilFragment -> navController.navigate(R.id.action_tournamentProfilFragment_to_favoritesFragment)
                        R.id.matchFragment -> navController.navigate(R.id.action_matchFragment_to_favoritesFragment)
                    }
                }
            }
            true
        }

        binding.atpWtaSwitch.findViewById<CardView>(R.id.atp_logo).setOnClickListener {
            binding.atpWtaSwitch.findViewById<CardView>(R.id.atp_logo).setCardBackgroundColor(getColor(R.color.default_text))
            binding.atpWtaSwitch.findViewById<CardView>(R.id.wta_logo).setCardBackgroundColor(getColor(R.color.section))
            binding.atpWtaSwitch.findViewById<CardView>(R.id.atp_logo).bringToFront()
            binding.atpWtaSwitch.findViewById<ImageView>(R.id.atp_logo_imageView).setImageResource(R.drawable.atp_noir)
            binding.atpWtaSwitch.findViewById<ImageView>(R.id.wta_logo_imageView).setImageResource(R.drawable.wta_logo_blanc)
        }

        binding.atpWtaSwitch.findViewById<CardView>(R.id.wta_logo).setOnClickListener {
            binding.atpWtaSwitch.findViewById<CardView>(R.id.wta_logo).setCardBackgroundColor(getColor(R.color.default_text))
            binding.atpWtaSwitch.findViewById<CardView>(R.id.atp_logo).setCardBackgroundColor(getColor(R.color.section))
            binding.atpWtaSwitch.findViewById<CardView>(R.id.wta_logo).bringToFront()
            binding.atpWtaSwitch.findViewById<ImageView>(R.id.wta_logo_imageView).setImageResource(R.drawable.wta_logo)
            binding.atpWtaSwitch.findViewById<ImageView>(R.id.atp_logo_imageView).setImageResource(R.drawable.atp_blanc)
        }


    }
}