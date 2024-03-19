package fr.gmarquette.atpwtatour.model.season.matches

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.gmarquette.atpwtatour.model.season.Matches

@Database(entities = [Matches::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterMatches::class)
abstract class MatchesDatabase : RoomDatabase() {

    abstract fun matchesDAO(): MatchesDAO

    companion object {
        @Volatile
        private var INSTANCE: MatchesDatabase? = null

        fun getDatabase(context: Context): MatchesDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MatchesDatabase::class.java,
                    "matches_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}