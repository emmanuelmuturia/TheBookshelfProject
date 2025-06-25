package thebookshelfproject.extras

interface Platform {
    val name: String
}

expect fun getPlatform(): thebookshelfproject.extras.Platform