package fr.gmarquette.atpwtatour.model.season.tournament

import androidx.room.TypeConverter
import fr.gmarquette.atpwtatour.model.season.Matches

class TypeConverterTournament
{
    @TypeConverter
    fun fromListMatches(value: List<Matches>): String
    {
        return value.joinToString(separator = ",") { it.toString() }
    }

    @TypeConverter
    fun toListMatches(value: String): List<Matches>
    {
        return value.split(",").map { Matches() }
    }

    @TypeConverter
    fun fromListString(value: List<String>): String
    {
        return value.joinToString(separator = ",") { it }
    }

    @TypeConverter
    fun toListString(value: String): List<String>
    {
        return value.split(",")
    }

}