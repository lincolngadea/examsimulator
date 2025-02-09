package com.examsimulator.model.entities

import com.examsimulator.model.enums.Role
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*


@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    @field:NotBlank(message = "User name is required")
    @field:Size(max = 255, message = "User name must be at most 255 characters")
    val name: String,

    @Column(unique = true, nullable = false, length = 255)
    @field:Size(max = 255, message = "Email must be at most 255 characters")
    @field:Email(message = "Invalid email format")
    @field:Size(max = 255, message = "Invalid email format")
    val email: String,

    @Column(nullable = false)
    @field:NotBlank(message = "User password is required")
    val password: String,

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = [JoinColumn(name = "user_id")])
    @Column(nullable = false, name = "role")
    val roles: Set<Role> = setOf(Role.USER),

    @Column(nullable = false)
    val enabled: Boolean = false,

    val verificationToken: String? = UUID.randomUUID().toString(),

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column(nullable = false)
    val updatedAt: LocalDateTime? = null
)

