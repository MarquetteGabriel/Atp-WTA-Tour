package fr.gmarquette.atpwtatour.view.tournamentProfil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import fr.gmarquette.atpwtatour.databinding.FragmentTournamentProfilBinding
import fr.gmarquette.atpwtatour.model.season.tournament.TournamentViewModel

class TournamentProfilFragment : Fragment() {

    private lateinit var tournamentViewModel: TournamentViewModel
    private lateinit var binding: FragmentTournamentProfilBinding
    private val args: TournamentProfilFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTournamentProfilBinding.inflate(inflater, container, false)
        var view = binding.root

        val matchData = args.playerName
        // TODO : recherche du tournoi en fonction du nom + fragment TournamentProfil
        //val tournament = tournamentViewModel.getTournamentByName(matchData)

        binding.tournamentName.text = matchData

        return view
    }

}