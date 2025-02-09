package com.examsimulator.model.entities

import jakarta.persistence.*
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
    val name: String,

    @Column(length = 500)
    val description: String,

    @Column(nullable = false, length = 255)
    val provider: String,

    @OneToMany(mappedBy = "certification", fetch = FetchType.LAZY)
    val exams: List<Exam> = emptyList(),

    @CreationTimestamp
    @Column(nullable = false)
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null
)
