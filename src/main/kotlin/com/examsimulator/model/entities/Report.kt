package com.examsimulator.model.entities

import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
data class Report(
    val id: Long = 0,
    val type: String,
    val generatedAt: LocalDateTime,
    val content: String
)
