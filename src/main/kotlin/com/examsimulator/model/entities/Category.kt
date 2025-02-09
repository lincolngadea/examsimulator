package com.examsimulator.model.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    val name: String,

    @Column(length = 500)
    val description: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certification_id")
    val certification: Certification? = null,

    @Column(nullable = false)
    val active: Boolean = true,

    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null,

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    val exams: List<Exam> = emptyList() // Lista de exames relacionados a esta categoria.
)