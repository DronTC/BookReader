package com.example.bookreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.navigation_view)

        // Setup toggle button
        val toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Setup navigation item click listener
        navView.setNavigationItemSelectedListener { menuItem ->
            handleNavigationItemClick(menuItem.itemId)
            true
        }
    }

    private fun handleNavigationItemClick(itemId: Int) {
        // Handle navigation item click here
    }
}