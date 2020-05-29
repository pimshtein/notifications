package uts.hbpro.notification.core.entrypoint

import uts.hbpro.notification.core.entrypoint.dto.Message

interface PreparationInterface {
    fun prepare(message: String): Message
}