package com.zinab.memes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}fun openInstagramLink(view: View) {
    val instagramUrl = "https://www.instagram.com/zeinab_abdelrazik22/#"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl))

    // Try to open in Instagram app first if installed
    intent.setPackage("com.instagram.android")

    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // Fallback to browser if Instagram app not installed
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl)))
    }
}