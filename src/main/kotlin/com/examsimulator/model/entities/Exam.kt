package com.examsimulator.model.entities

import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
data class Exam(
    val id: Long = 0,
    val title: String,
    val description: String,
    val category: Category,
    val totalQuestions: Int = 0,
    val durationInMinutes: Int = 0,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)
