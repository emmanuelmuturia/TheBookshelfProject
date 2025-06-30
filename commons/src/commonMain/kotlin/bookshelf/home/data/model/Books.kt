package bookshelf.home.data.model

data class Books(
    val items: List<Item>? = null,
    val kind: String? = null,
    val totalItems: Int? = null,
)