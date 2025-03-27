package com.example.foxphotoapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoxPhoto(
    val image: String,
    val link: String
)
