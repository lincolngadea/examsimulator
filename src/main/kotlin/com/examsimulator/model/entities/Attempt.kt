package com.examsimulator.model.entities

import jakarta.persistence.*
import jakarta.validation.constraints.*
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
    @field:NotNull(message = "User is required")
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    @field:NotNull(message = "Exam is required")
    val exam: Exam,

    @Column(nullable = true)
    val score: Double? = null,

    @Column(nullable = false)
    @field:Min(value = 0, message = "Total correct must be non-negative")
    val totalCorrect: Int = 0,

    @Column(nullable = false)
    @field:Min(value = 0, message = "Total incorrect must be non-negative")
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
    @field:Min(value = 0, message = "Level must be non-negative")
    val level: Int = 0,

    @Column(nullable = false)
    @field:Min(value = 0, message = "Points must be non-negative")
    val points: Int = 0,

    @Column(length = 500)
    @field:Size(max = 500, message = "Badges must be at most 500 characters")
    val badges: String? = null,

    @Column(length = 1000)
    @field:Size(max = 1000, message = "Justification must be at most 1000 characters")
    val justification: String? = null, //Justificativa opcional sobre a escolha do nível de dificuldade

    @Column(length = 1000)
    @field:Size(max = 1000, message = "Feedback must be at most 1000 characters")
    val feedback: String? = null,

    @Column(nullable = false)
    @field:DecimalMin(value = "0.0", inclusive = true, message = "Progress must be at least 0.0")
    @field:DecimalMax(value = "100.0", inclusive = true, message = "Progress must be at most 100.0")
    val progress: Double = 0.0,

    @OneToMany(mappedBy = "attempt", fetch = FetchType.LAZY)
    val historicalAttempts: List<AttemptHistory>? = null,

    @Column(nullable = true)
    val duration: Long? = null //Tempo total de tentativas em segundos
)
