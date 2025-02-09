package com.examsimulator.model.entities

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
data class Exam(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    @field:NotBlank(message = "Exam title is required")
    @field:Size(max = 255, message = "Exam title most be at most 255 characters")
    val title: String,

    @Column(nullable = false, length = 500)
    @field:NotBlank(message = "Exam description is required")
    @field:Size(max = 500, message = "Exam description must be at most 500 characters")
    val description: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @field:NotNull(message = "Category is required")
    val category: Category,

    @Column(nullable = false)
    val totalQuestions: Int = 0,

    @Column(nullable = false)
    val durationInMinutes: Int = 0,

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime?,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exam")
    val questions: List<Question> = emptyList()
)
