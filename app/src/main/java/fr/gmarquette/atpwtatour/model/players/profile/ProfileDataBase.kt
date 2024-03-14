package fr.gmarquette.atpwtatour.model.players.profile

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.gmarquette.atpwtatour.model.players.Profile

@Database(entities = [Profile::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
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
