package fr.gmarquette.atpwtatour.view.calendar

import fr.gmarquette.atpwtatour.model.season.Tournament
import fr.gmarquette.atpwtatour.model.season.tournament.TournamentViewModel

object Calendar {

    const val TYPE_HEADER = 0
    const val TYPE_ITEM = 1

    fun getItems(tournamentViewModel: TournamentViewModel) : ArrayList<Any>
    {
        val itemList = arrayListOf<Any>()
        val tournaments = tournamentViewModel.getTournaments().value as List<Tournament>
        for (tournament in tournaments)
        {
            val tournamentName = tournament.name
            val detailsTournaments = tournament.date + " - " + tournament.location
            val surfaceTournament = tournament.surface.description + " - " + tournament.io.description
            val lastWinner = tournament.pastChampions.last()
            val tournamentMonth = tournament.tournamentMonth
            val tournamentCategory = tournament.category.logo

            itemList.add(CalendarTournament.Item(tournamentName, detailsTournaments, surfaceTournament, lastWinner, tournamentCategory))
            itemList.add(CalendarTournament.Header(tournamentMonth))
        }

        return itemList
    }
}