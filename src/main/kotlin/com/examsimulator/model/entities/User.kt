package com.examsimulator.model.entities

import com.examsimulator.model.enums.Role
import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = [JoinColumn(name = "user_id")])
    @Column(nullable = false)
    val roles: Set<Role> = setOf(Role.USER),

    @Column(nullable = false)
    val enabled: Boolean = false,

    val verificationToken: String? = UUID.randomUUID().toString()
)

