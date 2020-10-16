package com.cisco.or.activity.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cisco.or.R
import com.cisco.or.fragments.WebViewFragment
import kotlinx.android.synthetic.main.fragment_webview.*

open class WebViewAuthenticationActivity : AppCompatActivity() {

    companion object {
        private val TAG = WebViewAuthenticationActivity::class.java.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_web_view)
        this.supportActionBar?.hide()

        val url = intent.getStringExtra("url")

        if (!url.isNullOrBlank()) {
            webView.webViewClient = WebViewFragment.CustomWebViewClient(progressBar)
            webView.loadUrl(url)
        }
    }
}