package com.ahuaman.screensplashkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform