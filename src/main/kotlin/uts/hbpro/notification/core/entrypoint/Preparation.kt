package uts.hbpro.notification.core.entrypoint

import com.google.gson.Gson
import org.springframework.stereotype.Service
import uts.hbpro.notification.core.entrypoint.dto.Message

@Service
class Preparation: PreparationInterface {
    override fun prepare(message: String): Message {
        // TODO create validation in the future
        // Validate message.

        // Deserialize message to object.
        return Gson().fromJson(message, Message::class.java)
    }
}