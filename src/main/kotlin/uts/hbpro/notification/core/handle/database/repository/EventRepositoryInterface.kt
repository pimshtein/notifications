package uts.hbpro.notification.core.handle.database.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import uts.hbpro.notification.core.handle.database.entity.Event

@Repository
interface EventRepositoryInterface : CrudRepository<Event, Long> {
    fun findOneByEvent(event: String): Event?
}