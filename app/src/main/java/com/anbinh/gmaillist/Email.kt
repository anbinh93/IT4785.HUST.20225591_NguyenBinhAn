package com.anbinh.gmaillist

data class Email(
    val senderName: String,
    val messagePreview: String,
    val timestamp: String,
    val isFavorite: Boolean
)
