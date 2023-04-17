package disney.character.info.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import disney.character.info.R
import disney.character.info.databinding.ActivityMainBinding
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    private lateinit var navGraph: NavGraph
    lateinit var binding: ActivityMainBinding


    override fun onBackPressed() {
        if (navController.navigateUp()) {
            NavController(this).popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    private fun initNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment
        navController = navHostFragment.navController
        val graphInflater = navHostFragment.navController.navInflater
        navGraph = graphInflater.inflate(R.navigation.nav_graph)
        navController.graph = navGraph
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavController()
    }

}








