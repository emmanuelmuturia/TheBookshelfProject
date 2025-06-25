package thebookshelfproject.extras

import platform.UIKit.UIDevice

class IOSPlatform: thebookshelfproject.extras.Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): thebookshelfproject.extras.Platform = IOSPlatform()