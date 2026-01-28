package com.example.traveljournal.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "travel_journal_entries")
data class TravelJourneyEntry(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val entryTitle: String,
    val entryNotes: String,
    val entryDate: Long
)