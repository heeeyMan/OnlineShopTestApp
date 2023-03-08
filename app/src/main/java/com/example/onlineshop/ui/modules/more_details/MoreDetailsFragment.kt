package com.example.onlineshop.ui.modules.more_details

import android.graphics.drawable.BitmapDrawable
import android.net.Uri
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
import com.example.onlineshop.datamodels.enums.BottomBarButtonType
import com.example.onlineshop.ui.adapters.ColorAdapter
import com.example.onlineshop.ui.adapters.ImageAdapter
import com.example.onlineshop.ui.item_decorations.PaddingBetweenItems
import com.example.onlineshop.utils.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso

class MoreDetailsFragment : Fragment(), OnSmallImageClickedListener {

    private var _binding: FragmentMoreDetailsBinding? = null
    private val binding get() = _binding
    private val moreDetailsViewModel: MoreDetailsViewModel by lazy {
        MoreDetailsAssembly(
            findNavController()
        ).build()
    }
    private var colorRecyclerView: RecyclerView? = null
    private var imageRecyclerView: RecyclerView? = null
    private val colorAdapter = ColorAdapter()
    private val imageAdapter = ImageAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreDetailsBinding.inflate(inflater, container, false)
        binding?.apply {
            colorRecyclerView = listColors
            imageRecyclerView = smallImages
            bottomSheet.addCart.setOnClickListener {
                moreDetailsViewModel.bottomBarClickHandle(BottomBarButtonType.ADD_CARD)
            }

            bottomSheet.positiveButton.setOnClickListener {
                moreDetailsViewModel.bottomBarClickHandle(BottomBarButtonType.POSITIVE)
            }

            bottomSheet.negativeButton.setOnClickListener {
                moreDetailsViewModel.bottomBarClickHandle(BottomBarButtonType.NEGATIVE)
            }
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
            price.observe(viewLifecycleOwner) {
                binding?.price?.text = getString(R.string.price, it)
            }
            largeImage.observe(viewLifecycleOwner) {
                if (it != null) {
                    //binding?.largeImage?.generalImg?.setImageDrawable(BitmapDrawable(resources, it))
                }
            }
        }
    }

    override fun onItemClick(imageUri: Uri) {
        moreDetailsViewModel.updateImage(imageUri)
    }
}