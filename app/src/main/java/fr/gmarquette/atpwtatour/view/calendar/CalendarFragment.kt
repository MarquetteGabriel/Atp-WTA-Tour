package fr.gmarquette.atpwtatour.view.calendar

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
import fr.gmarquette.atpwtatour.R
import fr.gmarquette.atpwtatour.databinding.FragmentCalendarBinding
import fr.gmarquette.atpwtatour.model.season.tournament.TournamentViewModel

class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalendarBinding
    private lateinit var tournamentViewModel: TournamentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calendar, container, false)
        val view = binding.root

        tournamentViewModel = ViewModelProvider(this).get(TournamentViewModel::class.java)
        val adapterList = CalendarAdapter {
            Navigation.findNavController(view.rootView.findViewById(R.id.navComponentATP)).navigate(R.id.playerProfileFragment)
        }

        val calendarTournamentList = Calendar.getItems(tournamentViewModel)
        adapterList.updateList(calendarTournamentList)

        binding.calendarTournamentRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = adapterList
        }

        return view
    }

}