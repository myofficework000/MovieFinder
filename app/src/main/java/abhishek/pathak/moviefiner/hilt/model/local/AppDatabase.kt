package abhishek.pathak.moviefiner.hilt.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieDao::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}