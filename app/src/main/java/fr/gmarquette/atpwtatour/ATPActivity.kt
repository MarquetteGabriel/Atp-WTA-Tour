package fr.gmarquette.atpwtatour

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import fr.gmarquette.atpwtatour.databinding.ActivityAtpBinding

class ATPActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityAtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navComponentATP) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.rankMenu -> {
                    navController.navigate(R.id.leaderboardFragment)
                }
                /*R.id.matchesMenu -> {
                    navController.navigate(R.id.match)
                }*/
                R.id.calendarMenu -> {
                    navController.navigate(R.id.calendarFragment)
                }
            }
            true
        }


    }
}