package uts.hbpro.notification.core.entrypoint.dto

data class Header(
        val id: String,
        val type: String,
        val time: String,
        val meta: Meta
)