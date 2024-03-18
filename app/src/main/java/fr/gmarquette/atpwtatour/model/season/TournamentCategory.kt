package fr.gmarquette.atpwtatour.model.season

import fr.gmarquette.atpwtatour.R

enum class TournamentCategory(val description: String, val logo: Int)
{
    JO("J0", R.drawable.jo),
    ATP_FINALS("ATP Finals", R.drawable.atp_finals),
    ATP_GRAND_CHELEM("ATP Grand Chelem", 0),
    ATP_1000("ATP 1000", R.drawable.atp_1000),
    ATP_500("ATP 500", R.drawable.atp_500),
    ATP_250("ATP 250", R.drawable.atp_250),
    WTA_FINALS("WTA Finals", 0),
    WTA_GRAND_CHELEM("WTA Grand Chelem", 0),
    WTA_1000("WTA 1000", R.drawable.wta_1000),
    WTA_500("WTA 500", 0),
    WTA_250("WTA 250", 0),
    WTA_125("WTA 125", 0),
    DAVIS_CUP("Davis Cup", R.drawable.davis_cup),
    UNITED_CUP("United Cup", R.drawable.united_cup),
    ROLLAND_GARROS("Rolland Garros", R.drawable.rolland_garros),
    WIMBLEDON("Wimbledon", R.drawable.wimbledon),
    US_OPEN("US Open", R.drawable.us_open),
    AUSTRALIAN_OPEN("Australian Open", R.drawable.australian_open),
}
