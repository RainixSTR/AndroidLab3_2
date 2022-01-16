package com.rainixstr.androidlab3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.rainixstr.androidlab3_2.databinding.ActivitySecondBinding

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        binding.bnToActivity1.setOnClickListener {
            finish()
        }
        binding.bnToActivity3.setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivityForResult(intent, 0)
        }
        binding.bnToAboutActivity.setOnItemSelectedListener { toAboutActivity(it) }
        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 1) {
            finish()
        }
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