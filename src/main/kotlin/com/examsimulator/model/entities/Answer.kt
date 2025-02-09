package com.examsimulator.model.entities

import jakarta.persistence.Entity

@Entity
data class Answer (
    val id: Long = 0,
    val question: Question,
    val text: String,
    val isCorrect: Boolean
)