package uts.hbpro.notification.core.handle.handler

import uts.hbpro.notification.core.entrypoint.dto.Message

interface MessageHandlerInterface {
    fun handle(message: Message)
}