package com.ucc.itdept

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StaffFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_staff, container, false)

        // Staff data
        val staffList = listOf(
            Staff(
                name = "Dr. John Brown",
                title = "Head of Department",
                phone = "876-555-0101",
                email = "hod.it@ucc.edu.jm",
                photoResId = R.drawable.staff_avatar_1
            ),
            Staff(
                name = "Prof. Sandra Williams",
                title = "Senior Lecturer - Programming",
                phone = "876-555-0102",
                email = "s.williams@ucc.edu.jm",
                photoResId = R.drawable.staff_avatar_2
            ),
            Staff(
                name = "Mr. Kevin Thompson",
                title = "Lecturer - Networking",
                phone = "876-555-0103",
                email = "k.thompson@ucc.edu.jm",
                photoResId = R.drawable.staff_avatar_3
            ),
            Staff(
                name = "Ms. Diana Clarke",
                title = "Lecturer - Database Systems",
                phone = "876-555-0104",
                email = "d.clarke@ucc.edu.jm",
                photoResId = R.drawable.staff_avatar_4
            ),
            Staff(
                name = "Mr. Andre Reid",
                title = "Lecturer - Web Development",
                phone = "876-555-0105",
                email = "a.reid@ucc.edu.jm",
                photoResId = R.drawable.staff_avatar_5
            )
        )

        // Set up RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.staffRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = StaffAdapter(staffList)

        return view
    }
}