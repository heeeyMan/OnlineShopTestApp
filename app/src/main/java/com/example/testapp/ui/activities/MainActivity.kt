package com.example.testapp.ui.activities

import android.os.Bundle
import android.text.SpannableString
import android.text.SpannedString
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.testapp.R
import com.example.testapp.database.Dependencies
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.utils.ANNOTATION_KEY
import com.example.testapp.utils.ANNOTATION_VALUE_DATA
import com.example.testapp.utils.ZERO
import com.example.testapp.utils.colorItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Dependencies.init(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.bottomNavigationView
        val drawView = binding.drawerBar.drawerLayout
        val toolbar = binding.drawerBar.mainToolbar.toolbar


        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.drawerBar.navHostFragmentActivityMain.id) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home -> {
                    showToolBar()
                    showBottomNavBar()
                    binding.apply {
                        drawerBar.mainToolbar.profileIcon.visibility = View.VISIBLE
                        drawerBar.mainToolbar.toolbarTitle.setTextSize(
                            ZERO,
                            resources.getDimension(R.dimen.text_size_20)
                        )
                        val title = getText(R.string.trade_by_data) as SpannedString
                        drawerBar.mainToolbar.toolbarTitle.text =
                            SpannableString(title).colorItem(
                                title,
                                ANNOTATION_KEY,
                                ANNOTATION_VALUE_DATA
                            )
                    }
                }

                R.id.navigation_profile -> {
                    showToolBar()
                    showBottomNavBar()
                    binding.apply {
                        drawerBar.mainToolbar.toolbarTitle.text = getString(R.string.profile)
                        drawerBar.mainToolbar.profileIcon.visibility = View.GONE
                        drawerBar.mainToolbar.toolbarTitle.setTextSize(
                            ZERO,
                            resources.getDimension(R.dimen.text_size_15)
                        )
                    }
                }

                R.id.navigation_more -> {
                    hideBottomNavBar()
                    hideToolBar()
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

    private fun showBottomNavBar() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNavBar() {
        binding.bottomNavigationView.visibility = View.GONE
    }

    private fun showToolBar() {
        binding.apply {
            drawerBar.mainToolbar.toolbarTitle.visibility = View.VISIBLE
            drawerBar.mainToolbar.profileIcon.visibility = View.VISIBLE
        }
    }

    private fun hideToolBar() {
        binding.apply {
            drawerBar.mainToolbar.toolbarTitle.visibility = View.GONE
            drawerBar.mainToolbar.profileIcon.visibility = View.GONE
        }
    }
}