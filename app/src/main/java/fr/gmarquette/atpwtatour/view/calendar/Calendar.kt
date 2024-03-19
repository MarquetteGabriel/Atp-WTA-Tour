package fr.gmarquette.atpwtatour.view.calendar

import fr.gmarquette.atpwtatour.model.season.Surfaces
import fr.gmarquette.atpwtatour.model.season.Tournament
import fr.gmarquette.atpwtatour.model.season.TournamentCategory
import fr.gmarquette.atpwtatour.model.season.tournament.TournamentViewModel

object Calendar {

    const val TYPE_HEADER = 0
    const val TYPE_ITEM = 1

    fun getItems(tournamentViewModel: TournamentViewModel) : ArrayList<Any>
    {
        val itemList = arrayListOf<Any>()
        //val tournaments = tournamentViewModel.getTournaments().value as List<Tournament>

        // TODO : API liaison
        val tournaments = mutableListOf<Tournament>()
        tournaments.add(Tournament(TournamentCategory.ATP_1000, "Melbourne 1000", "27 sept", Surfaces.HARD, Surfaces.INDOOR, 0, "Melbourne", 64))
        tournaments.add(Tournament(TournamentCategory.JO, "Paris 1000", "27 feb", Surfaces.HARD, Surfaces.INDOOR, 0, "Paris", 64))
        tournaments.add(Tournament(TournamentCategory.ATP_500, "Rome 500", "27 sept", Surfaces.CLAY, Surfaces.OUTDOOR, 0, "Rome", 64))
        tournaments.add(Tournament(TournamentCategory.ATP_250, "Monte Carlo 250", "27 sept", Surfaces.CLAY, Surfaces.OUTDOOR, 0, "Monte Carlo", 64))
        tournaments.add(Tournament(TournamentCategory.ATP_1000, "Madrid 1000", "27 sept", Surfaces.CLAY, Surfaces.OUTDOOR, 0, "Madrid", 64))
        tournaments.add(Tournament(TournamentCategory.WTA_1000, "Miami 1000", "27 oct", Surfaces.HARD, Surfaces.OUTDOOR, 0, "Miami", 64))
        tournaments.add(Tournament(TournamentCategory.ROLLAND_GARROS, "Indian Wells 1000", "27 oct", Surfaces.HARD, Surfaces.OUTDOOR, 0, "Indian Wells", 64))
        tournaments.add(Tournament(TournamentCategory.WIMBLEDON, "Cincinnati 1000", "27 sept", Surfaces.HARD, Surfaces.OUTDOOR, 0, "Cincinnati", 64))
        tournaments.add(Tournament(TournamentCategory.UNITED_CUP, "Shanghai 1000", "27 jan", Surfaces.HARD, Surfaces.OUTDOOR, 0, "Shanghai", 64))
        tournaments.add(Tournament(TournamentCategory.US_OPEN, "Canada 1000", "27 sept", Surfaces.HARD, Surfaces.OUTDOOR, 0, "Canada", 64))
        tournaments.add(Tournament(TournamentCategory.AUSTRALIAN_OPEN, "Montreal 1000", "27 sept", Surfaces.HARD, Surfaces.OUTDOOR, 0, "Montreal", 64))
        tournaments.add(Tournament(TournamentCategory.ATP_1000, "Hamburg 1000", "27 sept", Surfaces.CLAY, Surfaces.OUTDOOR, 0, "Hamburg", 64))

        for (tournament in tournaments) {
            tournament.tournamentMonth = tournament.setTournamentMonth(tournament.date)
        }
        tournaments.sortBy { it.tournamentMonth }
        for (tournament in tournaments)
        {
            val tournamentName = tournament.name
            val detailsTournaments = tournament.date + " - " + tournament.location
            val surfaceTournament = tournament.surface.description + " - " + tournament.io.description
            val lastWinner = "Rafael Nadal"//tournament.pastChampions.last()
            val tournamentMonth = tournament.tournamentMonth
            val tournamentCategory = tournament.category.logo

            val headerExist = itemList.any { it is CalendarTournament.Header && it.month == getMonth(tournamentMonth) }
            if(!headerExist) {
                itemList.add(CalendarTournament.Header(getMonth(tournamentMonth)))
            }
            itemList.add(CalendarTournament.Item(tournamentName, detailsTournaments, surfaceTournament, lastWinner, tournamentCategory))
        }

        return itemList
    }

    fun getMonth(month: Int): String {
        return when (month) {
            1 -> "January"
            2 -> "February"
            3 -> "March"
            4 -> "April"
            5 -> "May"
            6 -> "June"
            7 -> "July"
            8 -> "August"
            9 -> "September"
            10 -> "October"
            11 -> "November"
            12 -> "December"
            else -> "Unknown"
        }
    }
}