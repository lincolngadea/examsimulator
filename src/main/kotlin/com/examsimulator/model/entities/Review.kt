package com.examsimulator.model.entities

import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
data class Review(
    val id: Long = 0,
    val question: Question,
    val reviewer: User?,
    val feedback: String,
    val createdAt: LocalDateTime
)
