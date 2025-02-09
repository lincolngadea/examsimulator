package com.examsimulator.model.entities

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(
    name = "certification",
    indexes = [Index(name = "idx_certification_name", columnList = "name")])
data class Certification(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    @field:NotBlank(message = "Certification name is required")
    @field:Size(max = 255, message = "Certification name must be at most 255 characters")
    val name: String,

    @Column(length = 500)
    @field:Size(max = 500, message = "Description must be at most 500 characters")
    val description: String,

    @Column(nullable = false, length = 255)
    @field:Size(max = 255, message = "Provider must be at most 255 characters")
    @field:NotBlank(message = "Provider is required")
    val provider: String,

    @OneToMany(mappedBy = "certification", fetch = FetchType.LAZY)
    val exams: List<Exam> = emptyList(),

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null
)
