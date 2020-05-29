package uts.hbpro.notification.core.entrypoint

import uts.hbpro.notification.core.handle.MessageHandler

class EntryPoint(): EntryPointInterface {
    // TODO change to autowire
    private val preparation = Preparation()
    private val messageHandler = MessageHandler()

    override fun handle(message: String) {
        try {
            // Prepare message and get serialized object.
            preparation.prepare(message)

            // Process business logic.
            messageHandler.handle(message)
        } catch (_ignored: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}