package com.id.narumi.ui.profile

import com.id.narumi.base.BaseFragment
import com.id.narumi.databinding.FragmentProfileBinding
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>(
    FragmentProfileBinding::inflate
), AndroidScopeComponent {
    override val viewModel: ProfileViewModel by viewModel()
    override val scope: Scope by fragmentScope()

    override fun initView() {
        viewModel.fetchProfileData()
        viewModel.userData.observe(viewLifecycleOwner) {
            with(binding) {
                tvProfilePageUsernameData.text = it.name
                tvProfilePageEmailData.text = it.email

                btnProfilePageLogout.setOnClickListener {
                    viewModel.logout()
                }
            }
        }
    }
}