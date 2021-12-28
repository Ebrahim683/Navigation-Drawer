package com.example.navigationdrawer

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawer_id, R.string.open, R.string.close
        )

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_id)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        nav_id.setNavigationItemSelectedListener { item ->
            Log.d(TAG, "onCreate: menu item selected!")
            when (item.itemId) {
                R.id.m_setting -> {
                    tv.text = "Setting"
                }
                R.id.m_email -> {
                    tv.text = "Email"
                }
                else -> {
                    tv.text = "Clicked! But id not matched!"
                }
            }
            item.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
