package com.ucc.itdept

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "itdept.db"
        const val DATABASE_VERSION = 1
        const val TABLE_COURSES = "courses"
        const val COL_ID = "id"
        const val COL_CODE = "code"
        const val COL_NAME = "name"
        const val COL_CREDITS = "credits"
        const val COL_DESCRIPTION = "description"
        const val COL_YEAR = "year"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_COURSES (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_CODE TEXT,
                $COL_NAME TEXT,
                $COL_CREDITS INTEGER,
                $COL_DESCRIPTION TEXT,
                $COL_YEAR INTEGER
            )
        """.trimIndent()
        db.execSQL(createTable)
        seedCourses(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_COURSES")
        onCreate(db)
    }

    private fun seedCourses(db: SQLiteDatabase) {
        val courses = listOf(
            Course(0, "ITT101", "Introduction to Computing", 3, "Fundamentals of computing, hardware, software, and basic programming concepts.", 1),
            Course(0, "ITT102", "Programming I", 3, "Introduction to programming using Python. Covers variables, loops, functions and basic data structures.", 1),
            Course(0, "ITT201", "Programming II", 3, "Advanced programming concepts including OOP, inheritance, and polymorphism using Java.", 2),
            Course(0, "ITT202", "Database Management Systems", 3, "Relational databases, SQL, normalization, and database design principles.", 2),
            Course(0, "ITT203", "Computer Networking", 3, "Network topologies, protocols, TCP/IP, OSI model and network security basics.", 2),
            Course(0, "ITT301", "Web Development", 3, "HTML, CSS, JavaScript and frameworks for building modern responsive websites.", 3),
            Course(0, "ITT302", "Systems Analysis and Design", 3, "SDLC methodologies, UML diagrams, requirements gathering and system modeling.", 3),
            Course(0, "ITT303", "Mobile Application Development", 3, "Developing Android and iOS applications using modern frameworks and tools.", 3),
            Course(0, "ITT401", "Software Engineering", 3, "Software development processes, agile methodologies, testing and project management.", 4),
            Course(0, "ITT402", "Information Security", 3, "Cybersecurity principles, cryptography, ethical hacking and security management.", 4)
        )

        courses.forEach { course ->
            val values = ContentValues().apply {
                put(COL_CODE, course.code)
                put(COL_NAME, course.name)
                put(COL_CREDITS, course.credits)
                put(COL_DESCRIPTION, course.description)
                put(COL_YEAR, course.year)
            }
            db.insert(TABLE_COURSES, null, values)
        }
    }

    fun getAllCourses(): List<Course> {
        val courses = mutableListOf<Course>()
        val db = readableDatabase
        val cursor = db.query(TABLE_COURSES, null, null, null, null, null, COL_YEAR)
        with(cursor) {
            while (moveToNext()) {
                courses.add(
                    Course(
                        getInt(getColumnIndexOrThrow(COL_ID)),
                        getString(getColumnIndexOrThrow(COL_CODE)),
                        getString(getColumnIndexOrThrow(COL_NAME)),
                        getInt(getColumnIndexOrThrow(COL_CREDITS)),
                        getString(getColumnIndexOrThrow(COL_DESCRIPTION)),
                        getInt(getColumnIndexOrThrow(COL_YEAR))
                    )
                )
            }
        }
        cursor.close()
        return courses
    }
}