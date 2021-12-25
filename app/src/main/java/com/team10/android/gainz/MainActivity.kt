package com.team10.android.gainz

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.team10.android.gainz.utils.SessionManager

class MainActivity : AppCompatActivity() {
  private lateinit var toggle: ActionBarDrawerToggle
  private lateinit var drawerLayout: DrawerLayout
  private lateinit var navigationView: NavigationView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    drawerLayout = findViewById(R.id.drawer_layout)
    toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
    drawerLayout.addDrawerListener(toggle)
    toggle.syncState()

    val workoutFragment = WorkoutListFragment()
    val registerFragment = RegisterFragment()
    val loginFragment = LoginFragment()

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    navigationView = findViewById(R.id.nav_view)
    navigationView.setNavigationItemSelectedListener {
      when (it.itemId) {
        R.id.workoutItem -> supportFragmentManager.beginTransaction().apply {
          replace(R.id.fragment_container_view, workoutFragment)
            .addToBackStack(null)
            .commit()
        }
        R.id.registerItem -> supportFragmentManager.beginTransaction().apply {
          replace(R.id.fragment_container_view, registerFragment)
            .addToBackStack(null)
            .commit()
        }
        R.id.loginItem -> supportFragmentManager.beginTransaction().apply {
          replace(R.id.fragment_container_view, loginFragment)
            .addToBackStack(null)
            .commit()
        }
        R.id.logOut -> {
          SessionManager(applicationContext).deleteAuthToken()
        }
      }
      true
    }

  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (toggle.onOptionsItemSelected(item)) {
      return true
    }
    return super.onOptionsItemSelected(item)
  }
}