package com.id.narumi.ui.auth.login

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.id.narumi.base.BaseFragment
import com.id.narumi.databinding.FragmentLoginBinding
import com.id.narumi.utils.Utils.ANALYTICS_BUTTON
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class LoginFragment :
    BaseFragment<FragmentLoginBinding, LoginViewModel>(FragmentLoginBinding::inflate), AndroidScopeComponent {
    override val viewModel: LoginViewModel by viewModel()
    override val scope: Scope by fragmentScope()

    override fun onResume() {
        super.onResume()
        viewModel.logScreen(binding.flTvHeaderTitle.text.toString())
    }

    override fun initListener() {
        with(binding) {
            flBtLogin.setOnClickListener {
                viewModel.logButton(
                    bundleOf(
                        ANALYTICS_BUTTON to "login"
                    )
                )
                val email = flEtEmail.text.toString()
                val password = flEtPassword.text.toString()
                viewModel.login(email = email, password = password)
            }

            flBtRegister.setOnClickListener {
                navigateToRegister()
            }
        }
    }

    override fun observeData() {
        viewModel.message.observe(viewLifecycleOwner) {
            showMessage(it)
        }
    }

    private fun navigateToRegister() {
        viewModel.logButton(
            bundleOf(
                ANALYTICS_BUTTON to "register"
            )
        )
        val navController = findNavController()
        navController.navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
    }
}