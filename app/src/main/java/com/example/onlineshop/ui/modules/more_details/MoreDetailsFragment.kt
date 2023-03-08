package com.example.onlineshop.ui.modules.more_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlineshop.assemblies.more_details.MoreDetailsAssembly
import com.example.onlineshop.databinding.FragmentMoreDetailsBinding

class MoreDetailsFragment : Fragment() {

    private var _binding: FragmentMoreDetailsBinding? = null
    private val binding get() = _binding
    private val moreDetailsViewModel: MoreDetailsViewModel by lazy {
        MoreDetailsAssembly(
            findNavController()
        ).build()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

}