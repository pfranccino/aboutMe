package com.pfranccino.learnApp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val email: String,
    val displayName: String,
    val photoUrl: String
)