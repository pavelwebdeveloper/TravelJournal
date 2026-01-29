package com.example.traveljournal.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "travel_entries_photos",
    foreignKeys = [
        ForeignKey(
            entity = TravelJournalEntry::class,
            parentColumns = ["id"],
            childColumns = ["entryId"],
            onDelete = ForeignKey.CASCADE
        )
    ])

data class TravelJournalEntryPhoto (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val entryId: Int,
    val photoUri: String
    )
