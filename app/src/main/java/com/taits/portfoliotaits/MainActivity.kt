package com.taits.portfoliotaits

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.taits.portfoliotaits.ui.aboutme.AboutMeFragment
import com.taits.portfoliotaits.ui.contacts.ContactsFragment
import com.taits.portfoliotaits.ui.education.EducationFragment
import com.taits.portfoliotaits.ui.plans.PlansFragment


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    fun setNavItemChecked(id: Int) {
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navMenu: Menu = navView.menu
        val item: MenuItem = navMenu.findItem(id)
        item.isChecked = true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val aboutMeFragment = AboutMeFragment.newInstance()
        val educationFragment = EducationFragment.newInstance()
        val contactsFragment = ContactsFragment.newInstance()
        val plansFragment = PlansFragment.newInstance()

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf("iojibka_2000@mail.ru"))
            email.putExtra(Intent.EXTRA_SUBJECT, "Job offer")
            email.putExtra(Intent.EXTRA_TEXT, "Hello, Julia!")
            email.type = "message/rfc822"
            startActivity(Intent.createChooser(email, "Choose an Email client :"))
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setItemIconTintList(null)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_aboutme, R.id.nav_education, R.id.nav_plans, R.id.nav_contacts
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_aboutme -> {
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.nav_host_fragment, aboutMeFragment)
                        .commit()
                }
                R.id.nav_education -> {
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.nav_host_fragment, educationFragment)
                        .commit()
                }
                R.id.nav_plans -> {
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.nav_host_fragment, plansFragment)
                        .commit()
                }
                R.id.nav_contacts -> {
                    supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.nav_host_fragment, contactsFragment)
                        .commit()
                }
            }
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }*/

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}