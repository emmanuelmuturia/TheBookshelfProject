package thebookshelfproject.extras

class AndroidPlatform : thebookshelfproject.extras.Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): thebookshelfproject.extras.Platform = AndroidPlatform()