package bookshelf.home.ui.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import bookshelf.home.ui.state.BookshelfScreenUIState
import bookshelf.home.ui.viewmodel.BookshelfScreenViewModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun BookshelfScreen() {

    val bookshelfScreenViewModel = koinViewModel<BookshelfScreenViewModel>()

    val bookshelfScreenUIState: BookshelfScreenUIState by bookshelfScreenViewModel.bookshelfScreenUIState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier =
                    Modifier.semantics {
                        contentDescription = "Bookshelf Screen Top App Bar"
                    },
                title = {
                    Text(
                        modifier =
                            Modifier.semantics {
                                contentDescription = "Bookshelf Screen Top App Bar Text"
                            },
                        text = "Bookshelf",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 21.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
            )
        },
    ) { paddingValues ->
        BookshelfScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            bookshelfScreenUIState = bookshelfScreenUIState
        )
    }

}

@Composable
private fun BookshelfScreenContent(
    modifier: Modifier,
    bookshelfScreenUIState: BookshelfScreenUIState
) {

    AnimatedVisibility(visible = bookshelfScreenUIState.isLoading) {
        Box(
            modifier =
                modifier
                    .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onBackground,
                strokeWidth = 3.dp,
                trackColor = MaterialTheme.colorScheme.background,
            )
        }
    }

    AnimatedVisibility(visible = bookshelfScreenUIState.error != null) {
        val context = LocalContext.current
        Toast.makeText(context, "${bookshelfScreenUIState.error}", Toast.LENGTH_LONG).show()
    }

    AnimatedVisibility(visible = bookshelfScreenUIState.books.isNotEmpty()) {

        LazyVerticalStaggeredGrid(
            modifier = modifier,
            columns = StaggeredGridCells.Fixed(count = 2),
            verticalItemSpacing = 3.dp,
            horizontalArrangement = Arrangement.spacedBy(space = 3.dp)
        ) {
            items(items = bookshelfScreenUIState.books) { book ->
                GlideImage(
                    modifier =
                        Modifier.fillMaxSize(),
                    imageModel = { book.items.first().volumeInfo.imageLinks.thumbnail },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center

                    )
                )
            }
        }

    }

}