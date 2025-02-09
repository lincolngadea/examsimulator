package com.examsimulator.model.entities

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    @field:NotBlank(message = "Name is required")
    @field:Size(max = 255, message = "Description must be at most 255 characters")
    val name: String,

    @Column(length = 500)
    @field:Size(max = 500, message = "Description must be at most 500 characters")
    val description: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certification_id")
    val certification: Certification? = null,

    @Column(nullable = false)
    val active: Boolean = true,

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null,

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    val exams: List<Exam> = emptyList() // Lista de exames relacionados a esta categoria.
)