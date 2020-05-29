package uts.hbpro.notification.core.entrypoint.dto

data class Message(
    val header: Header,
    val body: Map<String, Any>
)