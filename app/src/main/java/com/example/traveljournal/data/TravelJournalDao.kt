package com.example.traveljournal.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// Data Access Object
@Dao
interface TravelJournalDao {

    // Operations that can be performed for each JournalEntry object
    @Insert suspend fun addTravelEntry(entry: TravelJournalEntry): Int
    @Update suspend fun updateTravelEntry(entry: TravelJournalEntry)
    @Delete suspend fun deleteTravelEntry(entry: TravelJournalEntry)
    @Query("SELECT * FROM travel_journal_entries WHERE id = :id")
    fun getTravelJournalEntry(id: Int): Flow<TravelJournalEntry>
    @Query("SELECT * FROM travel_journal_entries ORDER BY entryDate DESC")
    fun getAllTravelJourneyEntries(): Flow<List<TravelJournalEntry>>

    // Operations that can be performed for each TravelEntryPhoto object
    @Insert suspend fun addTravelEntryPhoto(entry: TravelJournalEntryPhoto)
    @Query("SELECT * FROM travel_entries_photos WHERE entryId = :entryId")
    suspend fun getPhotosForTravelEntry(entryId: Int): List<TravelJournalEntryPhoto>
}