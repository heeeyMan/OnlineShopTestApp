package com.example.onlineshop.datamodels.items

data class MoreDetailsItem(
    var name: String,
    var description: String,
    var rating: String,
    var numberOfReviews: String,
    var price: String,
    var colors: ArrayList<String> = arrayListOf(),
    var imageUrls: ArrayList<String> = arrayListOf()
)
