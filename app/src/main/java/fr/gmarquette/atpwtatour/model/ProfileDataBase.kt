package fr.gmarquette.atpwtatour.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.gmarquette.atpwtatour.model.players.Profile

@Database(entities = [Profile::class], version = 1, exportSchema = false)
abstract class ProfileDataBase: RoomDatabase() {

    abstract fun profileDAO(): ProfileDAO

    companion object {
        @Volatile
        private var INSTANCE: ProfileDataBase? = null

        fun getDatabase(context: Context): ProfileDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProfileDataBase::class.java,
                    "profile_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
