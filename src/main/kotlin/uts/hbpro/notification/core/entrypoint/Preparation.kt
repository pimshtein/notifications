package uts.hbpro.notification.core.entrypoint

import com.google.gson.Gson
import uts.hbpro.notification.core.entrypoint.dto.Message

class Preparation: PreparationInterface {
    override fun prepare(message: String) {
        val messageObject = Gson().fromJson(message, Message::class.java)
        println(" [x] Received '$messageObject'")
        // Validate message.
        // Deserialize message to object.
    }
}