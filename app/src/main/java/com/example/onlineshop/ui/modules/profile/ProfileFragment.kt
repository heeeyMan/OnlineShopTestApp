package com.example.onlineshop.ui.modules.profile

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.assemblies.profile.ProfileAssembly
import com.example.onlineshop.databinding.FragmentProfileBinding
import com.example.onlineshop.datamodels.enums.ProfileItemType
import com.example.onlineshop.utils.OnProfileItemClickListener
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
    private val requestCode = 100
    private var imageUri: Uri? = null

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
        binding?.uploadItemButton?.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, requestCode)
        }
        return binding?.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == this.requestCode) {
            imageUri = data?.data
            binding?.icon?.setImageURI(imageUri)
        }
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
            fullName.observe(viewLifecycleOwner) {
                binding?.userName?.text = it
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