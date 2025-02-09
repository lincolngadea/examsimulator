package com.examsimulator.model.entities

import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
data class Attempt(
    val id: Long = 0,
    val user: User,
    val exam: Exam,
    val score: Double,
    val totalCorrect: Int,
    val totalIncorrect: Int,
    val startedAt: LocalDateTime,
    val finishedAt: LocalDateTime?
)
