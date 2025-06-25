package thebookshelfproject.thebookshelfproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform