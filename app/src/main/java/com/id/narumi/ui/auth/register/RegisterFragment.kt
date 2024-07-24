package com.id.narumi.ui.auth.register

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.id.narumi.R
import com.id.narumi.base.BaseFragment
import com.id.narumi.databinding.FragmentRegisterBinding
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterViewModel>(
    FragmentRegisterBinding::inflate
), AndroidScopeComponent {
    override val viewModel: RegisterViewModel by viewModel()
    override val scope: Scope by fragmentScope()


    override fun initListener() {
        with(binding) {
            frBtRegister.setOnClickListener {
                val email = frEtEmail.text.toString()
                val name = frEtName.text.toString()
                val password = frEtPassword.text.toString()
                viewModel.register(name = name, email = email, password = password)
            }

            frBtLogin.setOnClickListener {
                navigateToLogin()
            }
        }
    }

    override fun observeData() {
        viewModel.message.observe(viewLifecycleOwner) {
            showMessage(it)
        }
    }

    private fun navigateToLogin() {
        val navController = findNavController()
        navController.navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
    }
}