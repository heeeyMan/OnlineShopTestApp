package com.example.onlineshop.ui.modules.more_details

import android.annotation.SuppressLint
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
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
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.bottom_sheet_more.*
import kotlinx.android.synthetic.main.fragment_more_details.*

class MoreDetailsFragment : Fragment(), OnSmallImageClickedListener {
    private var _binding: FragmentMoreDetailsBinding? = null
    private val binding get() = _binding
    private val moreDetailsViewModel: MoreDetailsViewModel by lazy {
        MoreDetailsAssembly(
            findNavController(),
            requireContext()
        ).build()
    }
    private var colorRecyclerView: RecyclerView? = null
    private var imageRecyclerView: RecyclerView? = null
    private var colorAdapter: ColorAdapter? = null
    private var imageAdapter: ImageAdapter? = null

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreDetailsBinding.inflate(inflater, container, false)
        colorAdapter = ColorAdapter()
        imageAdapter = ImageAdapter(this)
        binding?.apply {
            largeImage.apply {
                generalImg.setFactory {
                    val imgView = ShapeableImageView(requireActivity())
                    imgView.apply {
                        background =
                            resources.getDrawable(R.drawable.item_background_cor_9, null)
                        outlineProvider = ViewOutlineProvider.BACKGROUND
                        clipToOutline = true
                        scaleType = ImageView.ScaleType.FIT_XY
                    }
                }
                likeElement.share.setOnClickListener {
                    moreDetailsViewModel.shareItemClicked()
                }
            }
            colorRecyclerView = listColors
            imageRecyclerView = smallImages
            bottomSheet.apply {
                addCart.setOnClickListener {
                    moreDetailsViewModel.bottomBarClickHandle(BottomBarButtonType.ADD_CARD)
                }

                positiveButton.setOnClickListener {
                    moreDetailsViewModel.bottomBarClickHandle(BottomBarButtonType.POSITIVE)
                }

                negativeButton.setOnClickListener {
                    moreDetailsViewModel.bottomBarClickHandle(BottomBarButtonType.NEGATIVE)
                }
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
                    rating.text = getString(R.string.rating, it.rating, it.numberOfReviews)
                    price.text = getString(R.string.price, it.price)
                    colorAdapter?.setMoreItems(it.colors)
                    imageAdapter?.setMoreItems(it.imageUrls)
                    updateImage(Uri.parse(it.imageUrls[ZERO]))
                }

            }
            price.observe(viewLifecycleOwner) {
                binding?.apply {
                    price.text = getString(R.string.price, it.first)
                    quantity.text = getString(R.string.quantity, it.second)
                }

            }
            largeImage.observe(viewLifecycleOwner) {
                binding?.largeImage?.generalImg?.setImageDrawable(BitmapDrawable(resources, it))
            }
        }
    }

    override fun onItemClick(imageUri: Uri) {
        moreDetailsViewModel.updateImage(imageUri)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        colorRecyclerView = null
        imageRecyclerView = null
        colorAdapter = null
        imageAdapter = null
    }
}