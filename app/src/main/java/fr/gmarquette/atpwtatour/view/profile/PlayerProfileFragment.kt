package fr.gmarquette.atpwtatour.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.gmarquette.atpwtatour.R

class PlayerProfileFragment : Fragment() {

    private var menuList: List<String> = listOf("Overview", "Stats", "Results")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_player_profile, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.playerProfileRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = PlayerProfileAdapter(menuList)
        {
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

        return view
    }
}