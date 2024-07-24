package com.id.narumi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.id.narumi.databinding.ActivityMainBinding
import com.id.narumi.ui.MainFragmentDirections
import com.id.narumi.ui.auth.login.LoginFragmentDirections
import com.id.narumi.ui.auth.register.RegisterFragmentDirections
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class MainActivity : AppCompatActivity(), AndroidScopeComponent {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private lateinit var mainNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mainNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        mainNavController = mainNavHostFragment.navController

        viewModel.authState.observe(this) { isLogin ->
            if (isLogin) {
                navigateToHome()
            } else {
                navigateToLogin()
            }
        }
    }

    private fun navigateToHome() {
        val currentDestination = mainNavController.currentDestination?.id
        when (currentDestination) {
            R.id.loginFragment -> {
                mainNavController.navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment())
            }

            R.id.registerFragment -> {
                mainNavController.navigate(RegisterFragmentDirections.actionRegisterFragmentToMainFragment())
            }
        }

    }

    private fun navigateToLogin() {
        val currentDestination = mainNavController.currentDestination?.id
        when (currentDestination) {
            R.id.mainFragment -> {
                mainNavController.navigate(MainFragmentDirections.actionMainFragmentToLoginFragment())
            }
        }
    }

    override val scope: Scope by activityScope()
}