package uts.hbpro.notification.worker.amqp

class EntryPoint {
    companion object {
        suspend fun handle(message: String) {
            try {
                // Start processing message with coroutine
                // TODO true try-catch
            } catch (_ignored: InterruptedException) {
                Thread.currentThread().interrupt()
            }
        }
    }
}