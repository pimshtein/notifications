package uts.hbpro.notification.core.entrypoint

class Preparation: PreparationInterface {
    override fun prepare(message: String) {
        println(message)
        // Validate message.
        // Deserialize message to object.
    }
}