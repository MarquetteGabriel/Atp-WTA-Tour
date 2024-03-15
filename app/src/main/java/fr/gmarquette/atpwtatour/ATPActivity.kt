package fr.gmarquette.atpwtatour

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class ATPActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atp)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navComponentATP) as NavHostFragment
        navController = navHostFragment.navController


    }
}