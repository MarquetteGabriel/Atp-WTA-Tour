package fr.gmarquette.atpwtatour.view.calendar

sealed class CalendarTournament
{
    data class Item(val tournamentName: String, val detailsTournaments: String, val surfaceTournament: String, val lastWinner: String, val logo: Int) : CalendarTournament()
    data class Header(val month: String) : CalendarTournament()
}