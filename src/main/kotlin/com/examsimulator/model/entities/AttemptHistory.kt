package com.examsimulator.model.entities

import jakarta.persistence.*
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

@Entity
data class AttemptHistory(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attempt_id", nullable = false)
    @field:NotNull(message = "Attempt is requiret")
    val attempt: Attempt,

    @Column(nullable = false)
    @field:NotNull(message = "Score is required")
    val score: Double,

    @Column(nullable = false)
    @field:Min(value = 0, message = "Total correct must be non-negative")
    val totalCorrect: Int = 0,

    @Column(nullable = false)
    @field:Min(value = 0, message = "Total incorrect must be non-negative")
    val totalIncorrect: Int = 0,

    @Column(nullable = false)
    val progress: Double,

    @Column(nullable = true)
    val feedback: String? = null,

    @Column(nullable = false)
    @field:Min(value = 0, message = "Level must be non-negative")
    val level: Int = 0,

    @Column(nullable = false)
    @field:Min(value = 0, message = "Points must be non-negative")
    val points: Int = 0,

    @Column(nullable = true)
    val badges: String? = null,

    @Column(nullable = false)
    val recordedAt: LocalDateTime = LocalDateTime.now()
)