package com.rainixstr.androidlab3_2

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.rainixstr.androidlab3_2.databinding.ActivityThirdBinding

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityThirdBinding.inflate(layoutInflater)
        binding.bnToActivity1.setOnClickListener { toActivity1() }
        binding.bnToActivity2.setOnClickListener { toActivity2() }
        binding.bnToAboutActivity.setOnItemSelectedListener { toAboutActivity(it) }
        setContentView(binding.root)
    }

    private fun toActivity1() {
        startActivity(Intent(this, MainActivity::class.java)
            .setFlags(FLAG_ACTIVITY_CLEAR_TOP))
    }

    private fun toActivity2() {
        startActivity(Intent(this, Activity2::class.java)
            .setFlags(FLAG_ACTIVITY_CLEAR_TOP))
    }

    private fun toAboutActivity(menuItem: MenuItem) : Boolean {
        when (menuItem.itemId) {
            R.id.ic_info -> {
                startActivity(Intent(this, ActivityAbout::class.java))
            }
        }
        return false
    }
}