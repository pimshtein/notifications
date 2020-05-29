package uts.hbpro.notification.core.entrypoint

import org.springframework.stereotype.Component
import uts.hbpro.notification.core.handle.handler.MessageHandlerInterface

@Component
class EntryPoint(
        private val messageHandler: MessageHandlerInterface,
        private val preparation: PreparationInterface
) : EntryPointInterface {

    override fun handle(message: String) {
        try {
            // Prepare message and get serialized object.
            val messageData = preparation.prepare(message)

            // Process business logic.
            messageHandler.handle(messageData)
        } catch (_ignored: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}