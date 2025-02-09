package com.examsimulator.model.entities

import jakarta.persistence.Entity

@Entity
data class Category (
    val id: Long = 0,
    val name: String,
    val description: String
)