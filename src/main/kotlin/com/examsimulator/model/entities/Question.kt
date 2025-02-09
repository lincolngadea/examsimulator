package com.examsimulator.model.entities

import com.examsimulator.model.enums.QuestionStatus
import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
data class Question(
    val id: Long = 0,
    val exam: Exam,
    val text: String,
    val options: List<Answer>,
    val correctAnswer: Answer,
    val explanation: String,
    val createdBy: User,
    val status: QuestionStatus,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
