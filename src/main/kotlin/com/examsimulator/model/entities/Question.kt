package com.examsimulator.model.entities

import com.examsimulator.model.enums.QuestionStatus
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "exam_id",
        nullable = false
    )
    val exam: Exam,

    @Column(nullable = false, length = 1000)
    val text: String,

    @OneToMany(
        mappedBy = "question",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    val options: List<Answer>,

    @Column(nullable = false, length = 1000)
    val explanation: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", nullable = false)
    val createdBy: User,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: QuestionStatus,

    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null
)
