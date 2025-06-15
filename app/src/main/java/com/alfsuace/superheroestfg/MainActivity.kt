package com.alfsuace.superheroestfg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.alfsuace.superheroestfg.app.extensions.hide
import com.alfsuace.superheroestfg.app.extensions.visible
import com.alfsuace.superheroestfg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigationBar()
    }

    private fun setupNavigationBar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navBottomBar.setupWithNavController(navController)

        onNavigateToFragment(navController)
    }

    private fun onNavigateToFragment(navController: NavController) {
        val bottomNavBar = binding.navBottomBar

        val hideOn = setOf(
            R.id.superHeroDetailFragment,
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in hideOn) {
                bottomNavBar.hide()
            } else {
                bottomNavBar.visible()
            }
        }
    }

}