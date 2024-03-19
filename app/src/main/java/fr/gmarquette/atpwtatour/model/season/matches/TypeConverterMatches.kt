package fr.gmarquette.atpwtatour.model.season.matches

import androidx.room.TypeConverter
import fr.gmarquette.atpwtatour.model.players.Profile
import fr.gmarquette.atpwtatour.model.season.Score
import fr.gmarquette.atpwtatour.model.statistics.Stats

class TypeConverterMatches
{
    @TypeConverter
    fun fromProfile(value: Profile): String
    {
        return value.toString()
    }

    @TypeConverter
    fun toProfile(value: String): Profile
    {
        return Profile()
    }

    @TypeConverter
    fun fromScore(value: Score): String
    {
        return value.toString()
    }

    @TypeConverter
    fun toScore(value: String): Score
    {
        return Score()
    }

    @TypeConverter
    fun fromStats(value: Stats): String
    {
        return value.toString()
    }

    @TypeConverter
    fun toStats(value: String): Stats
    {
        return Stats()
    }
}