package `fun`.feellmoose.internal.model

data class Page<T>(val size: Int, val total: Int, val current: Int, val articles: List<T>)
