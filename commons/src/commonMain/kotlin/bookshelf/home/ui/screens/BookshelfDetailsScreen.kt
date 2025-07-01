package bookshelf.home.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

data class BookshelfDetailsScreen(val bookId: String) : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

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
                        Text(
                            modifier =
                                Modifier.semantics {
                                    contentDescription = "Bookshelf Details Screen Top App Bar Text"
                                },
                            text = ,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 21.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
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
                    }
                )
            },
        ) { paddingValues ->
            BookshelfDetailsScreenContent(
                modifier = Modifier.padding(paddingValues = paddingValues)
            )
        }
    }

}

@Composable
private fun BookshelfDetailsScreenContent(
    modifier: Modifier
) {



}