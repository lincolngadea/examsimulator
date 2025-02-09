package com.examsimulator.model.entities

import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.Column
import java.time.LocalDateTime

@Entity
data class AttemptHistory (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attempt_id", nullable = false)
    val attempt: Attempt,

    @Column(nullable = false)
    val score: Double,

    @Column(nullable = false)
    val totalCorrect: Int,

    @Column(nullable = false)
    val totalIncorrect: Int,

    @Column(nullable = false)
    val progress: Double,

    @Column(nullable = true)
    val feedback: String? = null,

    @Column(nullable = false)
    val level: Int,

    @Column(nullable = false)
    val points: Int,

    @Column(nullable = true)
    val badges: String? = null,

    @Column(nullable = false)
    val recordedAt: LocalDateTime = LocalDateTime.now()
)