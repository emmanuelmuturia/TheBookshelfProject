/*
 * Copyright 2025 The Bookshelf Project
 *
 * Licenced under the Apache License, Version 2.0 (the "Licence");
 * you may not use this file except in compliance with the Licence.
 * You may obtain a copy of the Licence at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */
package bookshelf.home.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import bookshelf.home.ui.state.BookshelfDetailsScreenUIState
import bookshelf.home.ui.viewmodel.BookshelfDetailsScreenViewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.koin.compose.viewmodel.koinViewModel

/**
 * This is the Home feature's Details Screen...
 */

data class BookshelfDetailsScreen(
    val bookId: String,
) : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val bookshelfDetailsScreenViewModel = koinViewModel<BookshelfDetailsScreenViewModel>()

        val bookshelfDetailsScreenUIState by bookshelfDetailsScreenViewModel.bookshelfDetailsScreenUIState.collectAsStateWithLifecycle()

        LaunchedEffect(key1 = bookId) {
            bookshelfDetailsScreenViewModel.getBookById(bookId = bookId)
        }

        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    modifier =
                        Modifier.semantics {
                            contentDescription = "Bookshelf Details Screen Top App Bar"
                        },
                    title = {
                        bookshelfDetailsScreenUIState.book?.volumeInfo?.title?.let {
                            Text(
                                modifier =
                                    Modifier.semantics {
                                        contentDescription =
                                            "Bookshelf Details Screen Top App Bar Text"
                                    }.padding(end = 10.dp),
                                text = it,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 21.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
                    navigationIcon = {
                        IconButton(onClick = {
                            navigator.pop()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                                contentDescription = "Arrow Back",
                                tint = MaterialTheme.colorScheme.onBackground,
                            )
                        }
                    },
                )
            },
        ) { paddingValues ->
            BookshelfDetailsScreenContent(
                modifier = Modifier.padding(paddingValues = paddingValues),
                bookshelfDetailsScreenUIState = bookshelfDetailsScreenUIState,
            )
        }
    }
}

@Composable
private fun BookshelfDetailsScreenContent(
    modifier: Modifier,
    bookshelfDetailsScreenUIState: BookshelfDetailsScreenUIState,
) {
    AnimatedVisibility(visible = bookshelfDetailsScreenUIState.isLoading) {
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

    AnimatedVisibility(visible = bookshelfDetailsScreenUIState.error != null) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            item {
                Text(text = "${bookshelfDetailsScreenUIState.error}")
            }
        }
    }

    AnimatedVisibility(visible = bookshelfDetailsScreenUIState.book != null) {
        LazyColumn(
            modifier =
                modifier
                    .fillMaxSize()
                    .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                CoilImage(
                    modifier =
                        Modifier.fillMaxWidth().fillMaxWidth(fraction = 0.6f)
                            .aspectRatio(ratio = 0.75f),
                    imageModel = { bookshelfDetailsScreenUIState.book?.volumeInfo?.imageLinks?.thumbnail },
                    imageOptions =
                        ImageOptions(
                            contentScale = ContentScale.Crop,
                            contentDescription = "Book Cover...",
                        ),
                )
            }

            item {
                bookshelfDetailsScreenUIState.book?.volumeInfo?.title?.let {
                    BookDetailRow(
                        label = "Title",
                        value = it,
                    )
                }
            }

            bookshelfDetailsScreenUIState.book?.volumeInfo?.authors?.forEach { author ->
                item {
                    BookDetailRow(label = "Author", value = author)
                }
            }

            bookshelfDetailsScreenUIState.book?.volumeInfo?.categories?.forEach { category ->
                item {
                    BookDetailRow(label = "Category", value = category)
                }
            }

            item {
                BookDetailRow(
                    label = "Published",
                    value =
                        bookshelfDetailsScreenUIState.book?.volumeInfo?.publishedDate
                            ?: "Unknown...",
                )
            }

            item {
                bookshelfDetailsScreenUIState.book?.volumeInfo?.language?.let {
                    BookDetailRow(
                        label = "Language",
                        value = it,
                    )
                }
            }

            item {
                BookDetailRow(
                    label = "Pages",
                    value =
                        bookshelfDetailsScreenUIState.book?.volumeInfo?.pageCount?.toString()
                            ?: "Unknown...",
                )
            }

            item {
                bookshelfDetailsScreenUIState.book?.volumeInfo?.maturityRating?.let {
                    BookDetailRow(
                        label = "Maturity",
                        value = it,
                    )
                }
            }
        }
    }
}

@Composable
fun BookDetailRow(
    label: String,
    value: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}