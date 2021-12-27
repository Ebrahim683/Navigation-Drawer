package com.example.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer_id, R.string.open, R.string.close)
        drawer_id.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        nav_id.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.m_setting -> {
                    tv.text = "Setting"
                }
                R.id.m_email -> {
                    tv.text = "Email"
                }
            }
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