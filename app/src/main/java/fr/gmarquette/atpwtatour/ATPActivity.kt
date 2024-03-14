package fr.gmarquette.atpwtatour

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import fr.gmarquette.atpwtatour.databinding.ActivityAtpBinding

class ATPActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAtpBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_atp)
        
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_atp) as NavHostFragment
        navController = navHostFragment.navController


    }
}