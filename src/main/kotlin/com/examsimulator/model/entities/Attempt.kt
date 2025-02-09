package com.examsimulator.model.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
data class Attempt(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    val exam: Exam,

    @Column(nullable = true)
    val score: Double? = null,

    @Column(nullable = false)
    val totalCorrect: Int = 0,

    @Column(nullable = false)
    val totalIncorrect: Int = 0,

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    val startedAt: LocalDateTime,

    @Column
    val finishedAt: LocalDateTime?,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null,

    @Column(nullable = false)
    val level: Int = 0,

    @Column(nullable = false)
    val points: Int = 0,

    @Column(length = 500)
    val badges: String? = null,

    @Column(length = 1000)
    val feedback: String? = null,

    @Column(nullable = false)
    val progress: Double = 0.0,

    @OneToMany(mappedBy = "attempt", fetch = FetchType.LAZY)
    val historicalAttempts: List<AttemptHistory>? = null,

    @Column(nullable = true)
    val duration: Long? = null //Tempo total de tentativas em segundos
)
