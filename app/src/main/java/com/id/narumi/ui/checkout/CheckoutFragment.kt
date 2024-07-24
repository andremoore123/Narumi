package com.id.narumi.ui.checkout

import androidx.fragment.app.viewModels
import com.id.narumi.base.BaseFragment
import com.id.narumi.databinding.FragmentCheckoutBinding
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.core.scope.Scope

class CheckoutFragment : BaseFragment<FragmentCheckoutBinding, CheckoutViewModel>(
    FragmentCheckoutBinding::inflate
), AndroidScopeComponent {
    override val viewModel: CheckoutViewModel by viewModels()
    override val scope: Scope by fragmentScope()

}