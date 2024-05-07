package `fun`.feellmoose.internal

interface Generator<R, T> {
    fun generate(resource: R): T
}