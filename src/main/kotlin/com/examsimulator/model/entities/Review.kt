package com.examsimulator.model.entities

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
data class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    @field:NotNull(message = "Question is required")
    val question: Question,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_id")
    val reviewer: User? = null,

    @Lob
    @Column(nullable = false)
    @field:NotBlank(message = "feedback is required")
    val feedback: String,

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)
