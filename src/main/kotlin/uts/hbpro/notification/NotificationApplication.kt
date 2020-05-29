package uts.hbpro.notification

import com.xenomachina.argparser.ArgParser
import org.springframework.boot.autoconfigure.SpringBootApplication
import uts.hbpro.notification.worker.amqp.config.Arguments
import uts.hbpro.notification.worker.amqp.Worker

@SpringBootApplication
class NotificationApplication

fun main(args: Array<String>)  {
	// Parse arguments.
	val parsedArgs = ArgParser(args).parseInto(::Arguments)

	// Start amqp worker.
	Worker(parsedArgs).start()
}
