package com.ucc.itdept

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.ucc.itdept.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up toolbar
        setSupportActionBar(binding.toolbar)

        // Set up drawer toggle
        toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout,
            binding.toolbar,
            R.string.app_name,
            R.string.app_name
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Load home fragment by default
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.navHostFragment, HomeFragment())
                .commit()
            supportActionBar?.title = "Home"
        }

        // Handle navigation drawer item clicks
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.navHostFragment, HomeFragment())
                        .commit()
                    supportActionBar?.title = "Home"
                }
                R.id.nav_staff -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.navHostFragment, StaffFragment())
                        .commit()
                    supportActionBar?.title = "Staff Directory"
                }
                R.id.nav_courses -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.navHostFragment, CoursesFragment())
                        .commit()
                    supportActionBar?.title = "Courses"
                }
                R.id.nav_admissions -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.navHostFragment, AdmissionsFragment())
                        .commit()
                    supportActionBar?.title = "Admissions"
                }
                R.id.nav_social -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.navHostFragment, SocialMediaFragment())
                        .commit()
                    supportActionBar?.title = "Social Media"
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // FAB opens email to HOD
        binding.fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:hod.it@ucc.edu.jm")
                putExtra(Intent.EXTRA_SUBJECT, "Inquiry to Head of Department")
            }
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            supportActionBar?.title = "Home"
        } else {
            super.onBackPressed()
        }
    }
}