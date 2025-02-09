package com.examsimulator.model.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
data class Exam(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    val title: String,

    @Column(nullable = false, length = 500)
    val description: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category,

    @Column(nullable = false)
    val totalQuestions: Int = 0,

    @Column(nullable = false)
    val durationInMinutes: Int = 0,

    @CreationTimestamp
    @Column(nullable = false)
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime?,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exam")
    val questions: List<Question> = emptyList()
)
