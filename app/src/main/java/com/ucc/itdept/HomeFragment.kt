package com.ucc.itdept

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val cardStaff = view.findViewById<androidx.cardview.widget.CardView>(R.id.cardStaff)
        val cardCourses = view.findViewById<androidx.cardview.widget.CardView>(R.id.cardCourses)
        val cardAdmissions = view.findViewById<androidx.cardview.widget.CardView>(R.id.cardAdmissions)
        val cardSocial = view.findViewById<androidx.cardview.widget.CardView>(R.id.cardSocial)

        cardStaff.setOnClickListener {
            (activity as? androidx.appcompat.app.AppCompatActivity)
                ?.supportActionBar?.title = "Staff Directory"
            navigateTo(StaffFragment())
        }

        cardCourses.setOnClickListener {
            (activity as? androidx.appcompat.app.AppCompatActivity)
                ?.supportActionBar?.title = "Courses"
            navigateTo(CoursesFragment())
        }

        cardAdmissions.setOnClickListener {
            (activity as? androidx.appcompat.app.AppCompatActivity)
                ?.supportActionBar?.title = "Admissions"
            navigateTo(AdmissionsFragment())
        }

        cardSocial.setOnClickListener {
            (activity as? androidx.appcompat.app.AppCompatActivity)
                ?.supportActionBar?.title = "Social Media"
            navigateTo(SocialMediaFragment())
        }

        return view
    }

    private fun navigateTo(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.navHostFragment, fragment)
            .addToBackStack(null)
            .commit()
    }
}