package com.examsimulator.model.entities

import java.time.LocalDateTime

data class Certification(
    val id: Long = 0,
    val name: String,
    val description: String,
    val provider: String,
    val exams: List<Exam> = emptyList(),
    val createdAt: LocalDateTime
)
