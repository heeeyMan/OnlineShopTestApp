package com.example.testapp.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.testapp.R
import com.example.testapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigationView
        val toolbar = binding.mainToolbar.toolbar

        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.navHostFragmentActivityMain.id) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            var textSizeId = 0
            when (destination.id) {
                R.id.navigation_home -> {
                    textSizeId = R.dimen.text_size_20
                    binding.mainToolbar.toolbarTitle.text = getString(R.string.trade_by_data)
                    binding.mainToolbar.profileIcon.visibility = View.VISIBLE

                }
                R.id.navigation_profile -> {
                    textSizeId = R.dimen.text_size_15
                    binding.mainToolbar.toolbarTitle.text = getString(R.string.profile)
                    binding.mainToolbar.profileIcon.visibility = View.GONE
                }
            }
            binding.mainToolbar.toolbarTitle.setTextSize(0, resources.getDimension(textSizeId))
        }

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_profile,
            )
        )

        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}