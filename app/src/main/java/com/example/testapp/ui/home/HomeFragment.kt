package com.example.testapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.assemblies.home.HomeAssembly
import com.example.testapp.databinding.FragmentHomeBinding
import com.example.testapp.ui.item_decorations.PaddingForLastElement
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private var recyclerView: RecyclerView? = null
    private var homeAdapter: GroupAdapter<GroupieViewHolder>? = null
    private val homeViewModel: HomeViewModel by lazy {
        HomeAssembly(
            requireContext(),
            findNavController()
        ).build()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bottomPadding = 77
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        homeAdapter = GroupAdapter()
        recyclerView = binding?.categoriesList
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.addItemDecoration(PaddingForLastElement(bottomPadding, requireContext()))
        recyclerView?.adapter = homeAdapter
        homeViewModel.initProfileList()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.apply {
            tradeData.observe(viewLifecycleOwner) {
                recyclerView?.adapter = homeAdapter?.apply {
                    clear()
                    addAll(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        recyclerView = null
        homeAdapter = null
    }
}