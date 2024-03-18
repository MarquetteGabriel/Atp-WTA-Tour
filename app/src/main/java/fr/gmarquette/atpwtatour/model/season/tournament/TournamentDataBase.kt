package fr.gmarquette.atpwtatour.model.season.tournament

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.gmarquette.atpwtatour.model.season.Tournament

@Database(entities = [Tournament::class], version = 1, exportSchema = true)
@TypeConverters(TypeConverterTournament::class)
abstract class TournamentDataBase: RoomDatabase() {

    abstract fun tournamentDAO(): TournamentDAO

    companion object {
        @Volatile
        private var INSTANCE: TournamentDataBase? = null

        fun getDatabase(context: Context): TournamentDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TournamentDataBase::class.java,
                    "tournament_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
