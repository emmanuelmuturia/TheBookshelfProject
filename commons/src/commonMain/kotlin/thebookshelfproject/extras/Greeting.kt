package thebookshelfproject.extras

class Greeting {
    private val platform: thebookshelfproject.extras.Platform =
        thebookshelfproject.extras.getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}