package com.example.onlineshop.ui.modules.more_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlineshop.databinding.BottomSheetMoreBinding
import com.example.onlineshop.datamodels.enums.BottomBarButtonType
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetMoreInfo(
    private val click: (type: BottomBarButtonType) -> Unit,
) :
    BottomSheetDialogFragment() {
    private var _binding: BottomSheetMoreBinding? = null
    private val binding: BottomSheetMoreBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetMoreBinding.inflate(layoutInflater)

        binding.negativeButton.setOnClickListener {
            click(BottomBarButtonType.NEGATIVE)
        }

        binding.positiveButton.setOnClickListener {
            click(BottomBarButtonType.POSITIVE)
        }

        binding.addCart.setOnClickListener {
            click(BottomBarButtonType.ADD_CARD)
        }
        return binding.root
    }
}