package com.example.vkedu1.domain

/**
 * Какая иконка у приложения. В domain нет ни Android, ни Compose,
 * поэтому тут просто тип, а в картинку его превращает presentation.
 */
enum class AppIconType {
    PERSON,
    SEND,
    LOCATION,
    CHECK,
    PLAY,
    STAR,
    CART,
    FAVORITE,
    INFO,
    CREATE,
    HOME,
}
