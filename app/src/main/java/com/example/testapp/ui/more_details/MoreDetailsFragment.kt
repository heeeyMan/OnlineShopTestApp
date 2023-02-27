package com.example.testapp.ui.more_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testapp.assemblies.more_details.MoreDetailsAssembly
import com.example.testapp.databinding.FragmentMoreDetailsBinding

class MoreDetailsFragment : Fragment() {

    private var _binding: FragmentMoreDetailsBinding? = null
    private val binding get() = _binding
    private val moreDetailsViewModel: MoreDetailsViewModel by lazy { MoreDetailsAssembly().build() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

}