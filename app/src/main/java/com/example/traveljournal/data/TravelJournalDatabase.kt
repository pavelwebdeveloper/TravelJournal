package com.example.traveljournal.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(
    // tables in travel-journal-db
    entities = [TravelJournalEntry::class, TravelJournalEntryPhoto::class],
    version = 1,
    // prevents saving schema history in a folder
    exportSchema = false
)

// database class definition
abstract class TravelJournalDatabase : RoomDatabase() {
    // connection to TravelJournal Data Access Object
    abstract fun travelJournalDao(): TravelJournalDao
    companion object {
        @Volatile
        private var INSTANCE: TravelJournalDatabase? = null

        // getting the database
        fun getDatabase(context: Context): TravelJournalDatabase {
            // building and returning the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TravelJournalDatabase::class.java, "travel-journal-db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}