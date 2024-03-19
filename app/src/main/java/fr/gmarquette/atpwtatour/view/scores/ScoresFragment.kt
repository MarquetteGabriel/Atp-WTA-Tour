package fr.gmarquette.atpwtatour.view.scores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rezwan.rcalenderlib.callbacks.YearRangeListener
import com.rezwan.rcalenderlib.models.RCalendar
import com.rezwan.rcalenderlib.views.YearRangeCalendarView
import fr.gmarquette.atpwtatour.R
import fr.gmarquette.atpwtatour.databinding.FragmentScoresBinding
import fr.gmarquette.atpwtatour.model.season.matches.MatchesViewModel
import fr.gmarquette.atpwtatour.view.tournamentProfil.TournamentProfilFragmentDirections
import java.time.LocalDate

class ScoresFragment : Fragment() {

    private lateinit var matchesViewModel: MatchesViewModel
    private lateinit var binding: FragmentScoresBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentScoresBinding.inflate(inflater, container, false)
        val view = binding.root

        matchesViewModel = ViewModelProvider(this).get(MatchesViewModel::class.java)

        val adapterList = MatchAdapter ({
            Navigation.findNavController(view.rootView.findViewById(R.id.navComponentATP))
                .navigate(TournamentProfilFragmentDirections.actionTournamentProfilFragmentToMatchFragment(it.match.id.toString()))
        }, {
            Navigation.findNavController(view.rootView.findViewById(R.id.navComponentATP))
                .navigate(TournamentProfilFragmentDirections.actionTournamentProfilFragmentToScoresFragment(it.tournamentName))
        })

        val matchesList = MatchObject.getItems(matchesViewModel, LocalDate.now())
        adapterList.updateList(matchesList)

        binding.matchRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = adapterList
        }

        val calendar: YearRangeCalendarView = view.findViewById(R.id.yearRangeCalendarView)
        val today = calendar.today()
        val startDate = today.minusDays(3)
        val endDate = today.plusDays(3)
        calendar.setYearRange(startDate.year, endDate.year)
        calendar.gotoDate(today.toString())
        calendar.setIsDateSticky(true)

        calendar.setYearRangeListener(object : YearRangeListener {
            override fun OnDateClicked(rCalendar: RCalendar, position: Int) {
                updateListMatches(rCalendar.date)
            }

            override fun OnSelectedDateFound(
                rCalendar: RCalendar,
                firstDayOfWeek: String,
                lastDayOfWeek: String,
                dayPosition: Int,
                currentPageNum: Int
            ) {
                updateListMatches(rCalendar.date)
            }
        })




        return view
    }


    fun updateListMatches(date: org.joda.time.LocalDate){
        val matchesList = MatchObject.getItems(matchesViewModel, convertToLocalDate(date))

        if(matchesList.isEmpty()){
            binding.noMatchesTextView.bringToFront()
            binding.noMatchesTextView.visibility = View.VISIBLE
        }else{
            binding.matchRecyclerView.bringToFront()
            binding.noMatchesTextView.visibility = View.GONE
        }
    }

    private fun convertToLocalDate(jodaDate: org.joda.time.LocalDate): LocalDate {
        return LocalDate.of(jodaDate.year, jodaDate.monthOfYear, jodaDate.dayOfMonth)
    }

}