package com.example.bookreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.bookreader.models.Book
import com.example.bookreader.ui.BooksAndDocumentsFragment
import com.example.bookreader.ui.BooksReadFragment
import com.example.bookreader.ui.ReadingNowFragment
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var menuButton: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        drawerLayout = findViewById(R.id.drawer_layout)
        menuButton = findViewById(R.id.menu_button)
        textView = findViewById(R.id.header_textView)
        navigationView = findViewById(R.id.navigation_view)

        menuButton.setOnClickListener{
            drawerLayout.openDrawer(navigationView)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_reading_now -> {
                    textView.text = getString(R.string.reading_now)
                    changeFragment(ReadingNowFragment())
                    true
                }
                R.id.nav_books_and_documents -> {
                    textView.text = getString(R.string.documents)
                    changeFragment(BooksAndDocumentsFragment())
                    true
                }
                R.id.nav_books_read -> {
                    textView.text = getString(R.string.books_read)
                    changeFragment(BooksReadFragment())
                    true
                }
                else -> false
            }
        }
    }
    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
        drawerLayout.closeDrawer(GravityCompat.START)
    }
}