package com.badbones69.crazyclaims.paper.api.files.annotations

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Comment(val value: String)