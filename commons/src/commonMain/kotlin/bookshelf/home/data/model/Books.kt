package bookshelf.home.data.model

data class Books(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)