package com.example.testapp.ui.modules.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.assemblies.profile.ProfileAssembly
import com.example.testapp.databinding.FragmentProfileBinding
import com.example.testapp.datamodels.enums.ProfileItemType
import com.example.testapp.utils.OnProfileItemClickListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class ProfileFragment : Fragment(), OnProfileItemClickListener {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding
    private var recyclerView: RecyclerView? = null
    private var profileAdapter: GroupAdapter<GroupieViewHolder>? = null
    private val click: OnProfileItemClickListener = this
    private val profileViewModel: ProfileViewModel by lazy {
        ProfileAssembly(
            requireContext(),
            click
        ).build()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        profileAdapter = GroupAdapter()
        recyclerView = binding?.profileList
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = profileAdapter
        }
        profileViewModel.initProfileList()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel.apply {
            profileItems.observe(viewLifecycleOwner) {
                recyclerView?.adapter = profileAdapter?.apply {
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
        profileAdapter = null
    }

    override fun onProfileItemClick(item: ProfileItemType) {
        profileViewModel.handleClick(item)
    }
}