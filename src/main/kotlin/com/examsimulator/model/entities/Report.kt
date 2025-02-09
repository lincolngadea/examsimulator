package com.examsimulator.model.entities

import com.examsimulator.model.enums.ReportType
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "report", indexes = [Index(name = "idx_report_type", columnList = "type")])
data class Report(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key.
    val id: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 255)
    val type: ReportType,

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    val generatedAt: LocalDateTime,

    @UpdateTimestamp
    @Column
    val updatedAt: LocalDateTime? = null,

    @Lob
    @Column(nullable = false)
    val content: String
)
