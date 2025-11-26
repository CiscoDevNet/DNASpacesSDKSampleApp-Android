package com.cisco.or.activity.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cisco.or.R
import com.cisco.or.databinding.ActivityWebViewBinding
import com.cisco.or.fragments.WebViewFragment

open class WebViewAuthenticationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    companion object {
        private val TAG = WebViewAuthenticationActivity::class.java.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()

        val url = intent.getStringExtra("url")

        if (!url.isNullOrBlank()) {
            binding.webviewLayout.webView.webViewClient = WebViewFragment.CustomWebViewClient(binding.webviewLayout.progressBar)
            binding.webviewLayout.webView.loadUrl(url)
        }
    }
}