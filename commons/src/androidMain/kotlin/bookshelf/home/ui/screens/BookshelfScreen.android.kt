package bookshelf.home.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
actual fun BookThumbnail(
    modifier: Modifier,
    imageUrl: String,
) {
    GlideImage(
        modifier = modifier.fillMaxWidth().wrapContentHeight(),
        model = imageUrl,
        contentScale = ContentScale.Crop,
        contentDescription = "Book Thumbnail..."
    )
}