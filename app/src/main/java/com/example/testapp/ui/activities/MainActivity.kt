package com.example.testapp.ui.activities

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannedString
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import    android.text.Annotation
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.testapp.R
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.bottomNavigationView
        val drawView = binding.drawerBar.drawerLayout
        val toolbar = binding.drawerBar.mainToolbar.toolbar


        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.drawerBar.navHostFragmentActivityMain.id) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val annotationKey = "font"
            val annotationValue = "data"
            when (destination.id) {
                R.id.navigation_home -> {
                    binding.drawerBar.mainToolbar.profileIcon.visibility = View.VISIBLE
                    binding.drawerBar.mainToolbar.toolbarTitle.setTextSize(
                        resources.getInteger(R.integer.zero),
                        resources.getDimension(R.dimen.text_size_20)
                    )
                    val title = getText(R.string.trade_by_data) as SpannedString
                    val annotations = title.getSpans(
                        resources.getInteger(R.integer.zero),
                        title.length, Annotation::class.java
                    )
                    val spannableTitle = SpannableString(title)
                    val annotation = annotations.find { it.key == annotationKey }
                    if (annotation?.value != null) {
                        annotations.find { it.value == annotationValue }
                        spannableTitle.setSpan(
                            ForegroundColorSpan(Color.BLUE),
                            title.getSpanStart(annotation),
                            title.getSpanEnd(annotation),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                    }
                    binding.drawerBar.mainToolbar.toolbarTitle.text = spannableTitle
                }
                R.id.navigation_profile -> {
                    binding.drawerBar.mainToolbar.toolbarTitle.text = getString(R.string.profile)
                    binding.drawerBar.mainToolbar.profileIcon.visibility = View.GONE
                    binding.drawerBar.mainToolbar.toolbarTitle.setTextSize(
                        0,
                        resources.getDimension(R.dimen.text_size_15)
                    )
                }
            }
        }

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_profile,
        ).setOpenableLayout(drawView).build()

        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawView)
        NavigationUI.setupWithNavController(binding.drawerBar.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.drawerBar.drawerLayout)
    }
}