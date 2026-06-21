package com.example.offlinesecondapproach

data class UserDto(
    val userId : Int,
    val id : Int,
    val title : String,
    val body: String
) {

    fun toEntity() = UserEntity(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}