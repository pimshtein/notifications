package uts.hbpro.notification.core.entrypoint.dto

data class Message<T>(
    val header: Header,
    val body: List<T>
)