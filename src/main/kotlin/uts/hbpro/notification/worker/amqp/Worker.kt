package uts.hbpro.notification.worker.amqp

import com.rabbitmq.client.AMQP
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import uts.hbpro.notification.core.entrypoint.EntryPointInterface
import uts.hbpro.notification.worker.WorkerInterface
import uts.hbpro.notification.worker.amqp.config.Arguments
import java.io.IOException

@Component
class Worker : WorkerInterface {
    @Autowired
    lateinit var entryPoint: EntryPointInterface
    
    override fun start(args: Arguments) {
        // Create connection.
        val factory = ConnectionFactory()
        factory.host = args.host
        factory.password = args.password
        factory.username = args.username
        val connection = factory.newConnection()
        val channel = connection.createChannel()

        // Create queue, exchange, bind queue.
        channel.queueDeclare(args.queue, false, false, true, null)
        channel.exchangeDeclare(args.exchange, args.exchangeType)
        channel.queueBind(args.queue, args.exchange, args.route)
        channel.basicQos(1)

        // Start consume.
        val consumer = object : DefaultConsumer(channel) {
            @Throws(IOException::class)
            override fun handleDelivery(
                    consumerTag: String,
                    envelope: Envelope,
                    properties: AMQP.BasicProperties,
                    body: ByteArray
            ) {
                val message = String(body, charset("UTF-8"))
                try {
                    entryPoint.handle(message)
                } finally {
                    println(" [x] Done")
                    channel.basicAck(envelope.deliveryTag, false)
                }
            }
        }

        channel.basicConsume(args.queue, false, consumer)

        println(" [*] Waiting for messages. To exit press CTRL+C")
    }
}
