package uts.hbpro.notification.worker

import uts.hbpro.notification.worker.amqp.config.Arguments

interface WorkerInterface {
    fun start(args: Arguments)
}