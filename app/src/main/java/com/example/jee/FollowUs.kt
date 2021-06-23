package com.example.jee

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_follow_us.*

class FollowUs : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follow_us)

        webView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webView() {
        wView.webViewClient= WebViewClient()
        wView.apply {
            loadUrl("https://www.instagram.com/niteshman29/")
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
        }
    }
}