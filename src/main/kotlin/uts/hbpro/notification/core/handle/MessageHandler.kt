package uts.hbpro.notification.core.handle

class MessageHandler: MessageHandlerInterface {
    override fun handle(message: String)
    {
        // Get event from database.
        // Get locale, recipients etc.
        // Compose html message from database text.
        // Send message to recipients.
    }
}