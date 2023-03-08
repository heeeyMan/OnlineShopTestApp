package com.example.onlineshop.ui.modules.more_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.assemblies.more_details.MoreDetailsAssembly
import com.example.onlineshop.databinding.FragmentMoreDetailsBinding
import com.example.onlineshop.ui.adapters.ColorAdapter
import com.example.onlineshop.ui.adapters.ImageAdapter
import com.example.onlineshop.ui.item_decorations.PaddingBetweenItems
import com.example.onlineshop.utils.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MoreDetailsFragment : Fragment() {

    private var _binding: FragmentMoreDetailsBinding? = null
    private val binding get() = _binding
    private val moreDetailsViewModel: MoreDetailsViewModel by lazy {
        MoreDetailsAssembly(
            findNavController()
        ).build()
    }
    private var colorRecyclerView: RecyclerView? =null
    private var imageRecyclerView: RecyclerView? =null
    private val colorAdapter = ColorAdapter()
    private val imageAdapter = ImageAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreDetailsBinding.inflate(inflater, container, false)
        binding?.apply {
            colorRecyclerView = listColors
            imageRecyclerView = smallImages
        }
        colorRecyclerView?.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = colorAdapter
            addItemDecoration(
                PaddingBetweenItems(
                    PADDING_FOURTEEN,
                    ZERO,
                    context
                )
            )
        }

        imageRecyclerView?.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = imageAdapter
            addItemDecoration(
                PaddingBetweenItems(
                    PADDING_FOUR,
                    ZERO,
                    context
                )
            )
        }
        moreDetailsViewModel.initMoreDetails()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moreDetailsViewModel.apply {
            moreDetailsData.observe(viewLifecycleOwner) {
                binding?.apply {
                    itemName.text = it.name
                    description.text = it.description
                    /*val text = getString(R.string.rating, it.rating, it.numberOfReviews) as CharSequence
                    val title = text as SpannedString
                    rating.text =
                        SpannableString(title).colorItem(
                            title,
                            ANNOTATION_KEY,
                            ANNOTATION_VALUE_COUNT_REVIEWS
                        )*/
                    price.text = getString(R.string.price, it.price)
                    colorAdapter.setMoreItems(it.colors)
                    imageAdapter.setMoreItems(it.imageUrls)
                }

            }
        }
    }
}