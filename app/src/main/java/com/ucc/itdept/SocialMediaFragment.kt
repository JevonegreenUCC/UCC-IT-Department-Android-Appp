package com.ucc.itdept

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout

class SocialMediaFragment : Fragment() {

    private lateinit var webView: WebView

    private val socialUrls = mapOf(
        "Facebook" to "https://m.facebook.com/UCCJamaica",
        "Twitter" to "https://twitter.com/UCCJamaica",
        "Instagram" to "https://www.instagram.com/uccjamaica"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_social_media, container, false)

        webView = view.findViewById(R.id.socialWebView)
        val tabLayout = view.findViewById<TabLayout>(R.id.socialTabLayout)

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
            userAgentString = "Mozilla/5.0 (Linux; Android 10; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36"
        }

        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                val url = request?.url.toString()
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    return true
                }
                // If it tries to redirect outside, open in Custom Tab
                if (!url.contains("facebook.com")) {
                    openInCustomTab(url)
                    return true
                }
                return false
            }
        }

        // Add tabs
        socialUrls.keys.forEach { tabLayout.addTab(tabLayout.newTab().setText(it)) }

        // Load Facebook by default in WebView
        webView.loadUrl(socialUrls["Facebook"]!!)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val platform = tab.text.toString()
                val url = socialUrls[platform]!!

                if (platform == "Facebook") {
                    // Facebook loads okay in WebView
                    webView.visibility = View.VISIBLE
                    webView.loadUrl(url)
                } else {
                    // Twitter and Instagram open in Chrome Custom Tab
                    webView.visibility = View.GONE
                    openInCustomTab(url)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        return view
    }

    private fun openInCustomTab(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder()
            .setShowTitle(true)
            .build()
        customTabsIntent.launchUrl(requireContext(), Uri.parse(url))
    }

    fun canGoBack(): Boolean = webView.canGoBack()
    fun goBack() = webView.goBack()
}