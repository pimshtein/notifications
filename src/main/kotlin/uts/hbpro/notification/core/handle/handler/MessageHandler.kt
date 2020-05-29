package uts.hbpro.notification.core.handle.handler

import org.springframework.stereotype.Component
import uts.hbpro.notification.core.entrypoint.dto.Message
import uts.hbpro.notification.core.handle.database.repository.EventRepositoryInterface

@Component
class MessageHandler(private val eventRepositoryInterface: EventRepositoryInterface) : MessageHandlerInterface {

    override fun handle(message: Message) {
        // Get event from database.
        eventRepositoryInterface.findOneByEvent(message.header.meta.eventName)?.let {
            println(it)
        }
        // Get locale, recipients etc.
        // Compose html message from database text.
        // Send message to recipients.
    }
}