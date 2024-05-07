package `fun`.feellmoose.internal.domain.auth

interface OAuth<C> {
    fun login(code: C): String
}