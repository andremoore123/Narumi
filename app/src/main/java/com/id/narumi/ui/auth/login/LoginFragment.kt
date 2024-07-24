package com.id.narumi.ui.auth.login

import com.id.narumi.base.BaseFragment
import com.id.narumi.databinding.FragmentLoginBinding
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class LoginFragment :
    BaseFragment<FragmentLoginBinding, LoginViewModel>(FragmentLoginBinding::inflate), AndroidScopeComponent {
    override val viewModel: LoginViewModel by viewModel()

    override fun initListener() {
        with(binding) {
            flBtLogin.setOnClickListener { 
                val email = flEtEmail.text.toString()
                val password = flEtPassword.text.toString()
                viewModel.login(email = email, password = password)
            }
        }
    }

    override fun observeData() {
        viewModel.message.observe(viewLifecycleOwner) {
            showMessage(it)
        }
    }

    override val scope: Scope by fragmentScope()
}