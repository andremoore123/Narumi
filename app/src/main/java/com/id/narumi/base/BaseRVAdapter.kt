package com.id.narumi.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

/**
 * Created by: andreputras.
 * Date: 24/07/24
 * Name: Andre Eka Putra Simanjuntak
 * Email: andremoore431@gmail.com
 */
abstract class BaseRVAdapter<T : Any, B : ViewBinding>(
    private val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> B,
) : Adapter<BaseRVAdapter.RVViewHolder>() {
    class RVViewHolder(itemView: View) : ViewHolder(itemView)

    private val itemList = mutableListOf<T>()
    protected lateinit var binding: B

    abstract fun createViewHolder(binding: B): RVViewHolder

    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        binding = bindingFactory.invoke(LayoutInflater.from(parent.context), parent, false)
        return createViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        val item = itemList[position]
        initView(item)
    }

    abstract fun initView(item: T)

    fun insertData(data: List<T>) {
        itemList.clear()
        itemList.addAll(data)
        notifyDataSetChanged()
    }
}