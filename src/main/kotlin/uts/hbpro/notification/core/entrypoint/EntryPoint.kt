package uts.hbpro.notification.core.entrypoint

class EntryPoint() {
    companion object {
        private val preparation = Preparation()
        fun handle(message: String) {
            try {
                preparation.prepare(message)
                // Get event from database.
                // Get locale, recipients etc.
                // Compose html message from database text.
                // Send message to recipients.
            } catch (_ignored: InterruptedException) {
                Thread.currentThread().interrupt()
            }
        }
    }
}