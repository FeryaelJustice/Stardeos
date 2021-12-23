package com.stardeos.stardeos.model

data class Video(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String,
    val data: String,
    val tags: List<Tag>,
    val duration: Long,
    val qualities: List<VideoQuality>,
    val speeds: List<VideoSpeed>,
    val authorId: Int,
    val views: Int,
    val likes: Int,
    val dislikes: Int,
    val comments: List<Comment>,
    val stardusts: List<Stardust>,
    val totalStardust: Int
)
