package uts.hbpro.notification.core.handle.database.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "notification")
data class Event(
        @Id @GeneratedValue
        val id: Long,
        val event: String,
        val name: String,
        val transport: String,
        val application: String,
        val messageType: String,
        val trash: Boolean
)