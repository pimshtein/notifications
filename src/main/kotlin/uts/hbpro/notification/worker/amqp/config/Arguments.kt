package uts.hbpro.notification.worker.amqp.config
import com.xenomachina.argparser.ArgParser

class Arguments(parser: ArgParser) {
    val host by parser.storing("amqp host")

    val username by parser.storing("amqp host")

    val password by parser.storing("amqp host")

    val queue by parser.storing("queue name")

    val exchange by parser.storing("exchange name")

    val exchangeType by parser.storing("exchange type")

    val route by parser.storing("exchange route")
}