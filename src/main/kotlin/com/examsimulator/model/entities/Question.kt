package com.examsimulator.model.entities

import com.examsimulator.model.enums.QuestionStatus
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    @field:NotNull(message = "Exam is required")
    val exam: Exam,

    @Column(nullable = false, length = 1000)
    @field:NotBlank(message = "Question Text is required")
    @field:Size(max = 1000, message = "Question Text must be at most 1000 characters")
    val text: String,

    @OneToMany(
        mappedBy = "question",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    @field:NotEmpty(message = "At least one answer option is required")
    val options: List<Answer> = emptyList(),

    @Column(nullable = false, length = 1000)
    @field: NotBlank(message = "Explanation is required")
    @field:Size(max = 1000, message = "Explanation must be at most 1000 characters")
    val explanation: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", nullable = false)
    @field:NotNull(message = "Created by user is required")
    val createdBy: User,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @field:NotNull(message = "Question Status is Required")
    val status: QuestionStatus,

    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null
)
