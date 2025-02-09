package com.examsimulator.model.entities

import jakarta.persistence.Entity

@Entity
data class History(
    val id: Long = 0,
    val user: User,
    val exam: Exam,
    val attempts: List<Attempt> = emptyList(),
    val averageScore: Double,
    val progressGraphData: String
)
