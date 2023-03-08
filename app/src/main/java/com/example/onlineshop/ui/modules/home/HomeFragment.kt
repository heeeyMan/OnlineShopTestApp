package com.example.onlineshop.ui.modules.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.assemblies.home.HomeAssembly
import com.example.onlineshop.databinding.FragmentHomeBinding
import com.example.onlineshop.ui.adapters.ColorAdapter
import com.example.onlineshop.ui.item_decorations.PaddingForLastElement
import com.example.onlineshop.utils.BOTTOM_PADDING
import com.example.onlineshop.utils.OnItemClickedListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class HomeFragment : Fragment(), OnItemClickedListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private val click: OnItemClickedListener = this
    private var recyclerView: RecyclerView? = null
    private var homeAdapter: GroupAdapter<GroupieViewHolder>? = null
    private val homeViewModel: HomeViewModel by lazy {
        HomeAssembly(
            requireContext(),
            findNavController(),
            click
        ).build()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        homeAdapter = GroupAdapter()
        recyclerView = binding?.categoriesList
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(PaddingForLastElement(BOTTOM_PADDING, requireContext()))
            adapter = homeAdapter
        }

        homeViewModel.apply {
            initProfileList()
            binding?.tryAgain?.setOnClickListener {
                showProgressBar()
                initProfileList()
            }
        }
        showProgressBar()
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
                hideProgressBar()
            }
            requestState.observe(viewLifecycleOwner) {
                binding?.apply {
                    errorText.apply {
                        isVisible = it.errorTextVisible()
                        text = getString(it.messageErrorText())
                    }
                    tryAgain.isVisible = it.tryAgainButtonVisible()
                }
                hideProgressBar()
            }

        }
    }

    private fun hideProgressBar() {
        binding?.progressBar?.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding?.progressBar?.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        recyclerView = null
        homeAdapter = null
    }

    override fun onItemClick(id: Int) {
        homeViewModel.openItem(id)
    }
}