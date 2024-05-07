package `fun`.feellmoose.internal.domain.user

data class User(
    val name: String? = "Anonymous",
    val role: Role = Role.user,
    val email: String? = null,
    val avatarUrl: String? = null,
)

