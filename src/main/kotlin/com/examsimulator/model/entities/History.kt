package com.examsimulator.model.entities

import jakarta.persistence.*

@Entity
data class History(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    val exam: Exam,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "history_id")
    val attempts: List<Attempt> = emptyList(),

    @Column(nullable = false)
    val averageScore: Double = 0.0,

    @Lob
    @Column(nullable = false)
    val progressGraphData: String
)
