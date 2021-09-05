package okhttp3.internal

import kotlin.annotation.AnnotationRetention.BINARY
import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.CONSTRUCTOR
import kotlin.annotation.AnnotationTarget.FUNCTION

@Retention(BINARY)
@MustBeDocumented
@Target(CONSTRUCTOR, CLASS, FUNCTION)
annotation class SuppressSignatureCheck
