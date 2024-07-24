package com.id.narumi.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.id.narumi.databinding.FragmentSectionBinding
import com.id.narumi.domain.trip.TripModel
import com.id.narumi.ui.adapter.AdapterSectionRV

class SectionFragment(private val onDetailClick: (TripModel) -> Unit) : Fragment() {

    private lateinit var binding: FragmentSectionBinding
    private lateinit var rvAdapter: AdapterSectionRV

    companion object {
        private const val ARG_TRIP_LIST = "arg_trip_list"

        fun newInstance(tripList: List<TripModel>, onDetailClick: (TripModel) -> Unit): SectionFragment {
            val fragment = SectionFragment(onDetailClick)
            val bundle = Bundle().apply {
                putParcelableArrayList(ARG_TRIP_LIST, ArrayList(tripList))
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSectionBinding.inflate(inflater, container, false)
        rvAdapter = AdapterSectionRV {
            onDetailClick(it)
        }
        binding.fsRvSection.run {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelableArrayList(ARG_TRIP_LIST, TripModel::class.java)?.let { tripList ->
            rvAdapter.insertData(tripList)
        }
    }
}
