package com.ucc.itdept

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class AdmissionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admissions, container, false)

        // Apply button opens UCC admissions page
        view.findViewById<com.google.android.material.button.MaterialButton>(R.id.applyButton)
            .setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ucc.edu.jm/apply/undergraduate"))
                startActivity(intent)
            }

        return view
    }
}