package fr.gmarquette.atpwtatour.view.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import fr.gmarquette.atpwtatour.R
import fr.gmarquette.atpwtatour.databinding.FragmentLeaderboardBinding
import fr.gmarquette.atpwtatour.model.players.profile.ProfileViewModel

class LeaderboardFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var binding: FragmentLeaderboardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_leaderboard, container, false)
        val view = binding.root

        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        val singleRankTextView: View = view.findViewById(R.id.leaderboardSinglesTextView)
        val raceRankTextView: View = view.findViewById(R.id.leaderboardRaceTextView)
        val liveRankTextView: View = view.findViewById(R.id.leaderboardLiveTextView)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.navComponentLeaderboard) as NavHostFragment
        val navController = navHostFragment.navController

        singleRankTextView.setOnClickListener {
            if(navController.currentDestination?.id == R.id.leaderboardRaceFragment)
                navController.navigate(R.id.action_leaderboardRaceFragment_to_leaderboardSinglesFragment)
            else if (navController.currentDestination?.id == R.id.leaderboardLiveFragment)
                navController.navigate(R.id.action_leaderboardLiveFragment_to_leaderboardSinglesFragment)
        }

        raceRankTextView.setOnClickListener {
            if(navController.currentDestination?.id == R.id.leaderboardSinglesFragment)
                navController.navigate(R.id.action_leaderboardSinglesFragment_to_leaderboardRaceFragment)
            else if (navController.currentDestination?.id == R.id.leaderboardLiveFragment)
                navController.navigate(R.id.action_leaderboardLiveFragment_to_leaderboardRaceFragment)
        }

        liveRankTextView.setOnClickListener {
            if(navController.currentDestination?.id == R.id.leaderboardRaceFragment)
                navController.navigate(R.id.action_leaderboardRaceFragment_to_leaderboardLiveFragment)
            else if (navController.currentDestination?.id == R.id.leaderboardSinglesFragment)
                navController.navigate(R.id.action_leaderboardSinglesFragment_to_leaderboardLiveFragment)
        }

        return view
    }
}