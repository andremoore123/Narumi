package com.id.narumi.ui.history

import androidx.lifecycle.ViewModel
import com.id.narumi.domain.transaction.ITransactionRepository

class HistoryViewModel(
    transactionRepository: ITransactionRepository,
) : ViewModel() {

    val history = transactionRepository.fetchTransactions()
}