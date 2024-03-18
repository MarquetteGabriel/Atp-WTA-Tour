package fr.gmarquette.atpwtatour.model.season.matches

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

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