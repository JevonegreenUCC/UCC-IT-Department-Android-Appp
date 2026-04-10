package com.ucc.itdept

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_courses, container, false)

        // Get courses from SQLite database
        val dbHelper = DatabaseHelper(requireContext())
        val courses = dbHelper.getAllCourses()

        // Set up RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.coursesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CourseAdapter(courses)

        return view
    }
}