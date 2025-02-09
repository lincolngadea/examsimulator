package com.examsimulator.model.entities

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
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
    @field:NotNull(message = "Question is required")
    val question: Question,

    @Column(nullable = false, length = 500)
    @field:NotBlank(message = "Answer text is required")
    @field:Size(max = 500, message = "Answer text must be at most 500 characters")
    val text: String,

    @Column(nullable = false)
    @field:NotNull(message = "isCorrect flag is required")
    val isCorrect: Boolean,

    @Column(nullable = false)
    @field:NotNull(message = "Order is required")
    val order: Int,

    @Column(length = 1000)
    @field:Size(max = 1000, message = "Explanation must be at most 1000 characters")
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
    @field:Size(max = 1000, message = "Feedback must be at most 1000 characters")
    val feedback: String? = null, //Feedback adicional sobre a resposta

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attempt_history_id")
    val attemptHistory: AttemptHistory? = null, // Vinculação com o histórico de tentativas, se necessário

    @Column(length = 1000)
    @field:Size(max = 1000, message = "Justification must be at most 1000 characters")
    val justification: String? = null // Justificativa opcional sobre a escolha da resposta
)