package com.examsimulator.model.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
data class Answer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    val question: Question,

    @Column(nullable = false, length = 500)
    val text: String,

    @Column(nullable = false)
    val isCorrect: Boolean,

    @Column(nullable = false)
    val order: Int,

    @Column(length = 1000)
    val explanation: String? = null,

    @Column(nullable = false)
    val active: Boolean = true,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val createdBy: User? = null,

    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null,

    @Column(length = 1000)
    val feedback: String? = null, //Feedback adicional sobre a resposta

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attempt_history_id")
    val attemptHistory: AttemptHistory? = null, // Vinculação com o histórico de tentativas, se necessário

    @Column(length = 1000)
    val justification: String? = null // Justificativa opcional sobre a escolha da resposta
)