package com.ucc.itdept

data class Course(
    val id: Int,
    val code: String,
    val name: String,
    val credits: Int,
    val description: String,
    val year: Int
)