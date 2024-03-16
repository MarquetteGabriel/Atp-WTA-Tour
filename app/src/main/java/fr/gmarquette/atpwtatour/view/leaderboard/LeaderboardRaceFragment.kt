package fr.gmarquette.atpwtatour.view.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.gmarquette.atpwtatour.Category
import fr.gmarquette.atpwtatour.R
import fr.gmarquette.atpwtatour.databinding.FragmentLeaderboardRaceBinding
import fr.gmarquette.atpwtatour.model.players.Career
import fr.gmarquette.atpwtatour.model.players.Plays
import fr.gmarquette.atpwtatour.model.players.Profile
import fr.gmarquette.atpwtatour.model.players.Rank
import fr.gmarquette.atpwtatour.model.players.profile.ProfileViewModel

class LeaderboardRaceFragment: Fragment()
{
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var binding: FragmentLeaderboardRaceBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_leaderboard_race, container, false)
        val view = binding.root
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        var tempList = mutableListOf<Profile>()
        val player1 = Profile(Category.ATP, "Sinner", "Jannik", "", 0, "", "", "Italy", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(2, 3, 2, 8500, 2, 3500, 1), "", )
        val player2 = Profile(Category.ATP, "Cazaux", "Arthur", "", 0, "", "", "France", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(71, 71, 56, 450, 56, 400, 2), "", )
        val player3 = Profile(Category.ATP, "Alcaraz", "Carlos", "", 0, "", "", "Spain", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(3, 2, 1, 8210, 3, 900, 3), "", )
        val player4 = Profile(Category.ATP, "Djokovic", "Novak", "", 0, "", "", "Serbia", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(1, 1, 1, 9700, 1, 500, 4), "", )
        val player5 = Profile(Category.ATP, "Monfils", "Gael", "", 0, "", "", "France", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(56, 56, 56, 400, 56, 400, 5), "", )
        val player6 = Profile(Category.ATP, "Nadal", "Rafael", "", 0, "", "", "Spain", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(417, 3, 1, 246, 417, 10, 86), "", )
        val player7 = Profile(Category.ATP, "Federer", "Roger", "", 0, "", "", "Switzerland", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(8, 8, 8, 5000, 8, 5000, 325), "", )
        val player8 = Profile(Category.ATP, "Thiem", "Dominic", "", 0, "", "", "Austria", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(5, 5, 5, 6000, 5, 6000, 12), "", )
        val player9 = Profile(Category.ATP, "Zverev", "Alexander", "", 0, "", "", "Germany", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(4, 4, 4, 7000, 4, 7000, 23), "", )
        val player10 = Profile(Category.ATP, "Medvedev", "Daniil", "", 0, "", "", "Russia", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(6, 6, 6, 5500, 6, 5500, 8), "", )
        val player11 = Profile(Category.ATP, "Tsitsipas", "Stefanos", "", 0, "", "", "Greece", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(7, 7, 7, 5200, 7, 5200, 7), "", )
        val player12 = Profile(Category.ATP, "Rublev", "Andrey", "", 0, "", "", "Russia", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(9, 9, 9, 4800, 9, 4800, 234), "", )
        val player13 = Profile(Category.ATP, "Berrettini", "Matteo", "", 0, "", "", "Italy", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(10, 10, 10, 4700, 10, 4700, 1242), "", )
        val player14 = Profile(Category.ATP, "Schwartzman", "Diego", "", 0, "", "", "Argentina", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(11, 11, 11, 4600, 11, 4600, 35), "", )
        val player15 = Profile(Category.ATP, "Garin", "Cristian", "", 0, "", "", "Chile", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(12, 12, 12, 4500, 12, 4500, 32), "", )
        val player16 = Profile(Category.ATP, "Shapovalov", "Denis", "", 0, "", "", "Canada", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(13, 13, 13, 4400, 13, 4400, 31), "", )
        val player17 = Profile(Category.ATP, "Bautista Agut", "Roberto", "", 0, "", "", "Spain", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(14, 14, 14, 4300, 14, 4300, 30), "", )
        val player18 = Profile(Category.ATP, "Carreno Busta", "Pablo", "", 0, "", "", "Spain", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(15, 15, 15, 4200, 15, 4200, 29), "", )
        val player19 = Profile(Category.ATP, "Fognini", "Fabio", "", 0, "", "", "Italy", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(16, 16, 16, 4100, 16, 4100, 28), "", )
        val player20 = Profile(Category.ATP, "Auger-Aliassime", "Felix", "", 0, "", "", "Canada", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(17, 17, 17, 4000, 17, 4000, 27), "", )
        val player21 = Profile(Category.ATP, "Goffin", "David", "", 0, "", "", "Belgium", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(18, 18, 18, 3900, 18, 3900, 26), "", )
        val player22 = Profile(Category.ATP, "Paire", "Benoit", "", 0, "", "", "France", "", "", Plays.RIGHT_HANDED, Plays.TWO_HANDED_BACKHAND, 0, Career(), Rank(19, 19, 19, 3800, 19, 3800, 25), "", )

        player1.codeID="IT"
        player2.codeID="FR"
        player3.codeID="ES"
        player4.codeID="RS"
        player5.codeID="FR"
        player6.codeID="ES"
        player7.codeID="CH"
        player8.codeID="AT"
        player9.codeID="DE"
        player10.codeID="RU"
        player11.codeID="GR"
        player12.codeID="RU"
        player13.codeID="IT"
        player14.codeID="AR"
        player15.codeID="CL"
        player16.codeID="CA"
        player17.codeID="ES"
        player18.codeID="ES"
        player19.codeID="IT"
        player20.codeID="CA"
        player21.codeID="BE"
        player22.codeID="FR"


        tempList.add(player1)
        tempList.add(player2)
        tempList.add(player3)
        tempList.add(player4)
        tempList.add(player5)
        tempList.add(player6)
        tempList.add(player7)
        tempList.add(player8)
        tempList.add(player9)
        tempList.add(player10)
        tempList.add(player11)
        tempList.add(player12)
        tempList.add(player13)
        tempList.add(player14)
        tempList.add(player15)
        tempList.add(player16)
        tempList.add(player17)
        tempList.add(player18)
        tempList.add(player19)
        tempList.add(player20)
        tempList.add(player21)
        tempList.add(player22)

        tempList.sortByDescending { it.rank.racePoints }
        val recyclerView: RecyclerView = view.findViewById(R.id.leaderboardRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = LeaderboardRaceAdapter(tempList, requireContext()) {
            Navigation.findNavController(view.rootView.findViewById(R.id.navComponentATP)).navigate(R.id.playerProfileFragment)
        }

        return view
    }
}