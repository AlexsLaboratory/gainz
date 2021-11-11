package com.team10.android.gainz

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import com.google.android.material.navigation.NavigationView
import com.team10.android.gainz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var toggle: ActionBarDrawerToggle
  private lateinit var navController: NavController
  private lateinit var binding: ActivityMainBinding
  private lateinit var drawerLayout: DrawerLayout
  private lateinit var navigationView: NavigationView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    drawerLayout = findViewById(R.id.drawer_layout)
    toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
    drawerLayout.addDrawerListener(toggle)
    toggle.syncState()

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    navigationView = findViewById(R.id.nav_view)
    navigationView.setNavigationItemSelectedListener {
      when(it.itemId) {
        R.id.workoutItem -> Toast.makeText(applicationContext, "Workout Item Clicked", Toast.LENGTH_SHORT).show()
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