package rabbitmq.grails

import com.budjb.rabbitmq.publisher.RabbitMessagePublisher
import grails.transaction.Transactional

@Transactional
class MessageService {

    RabbitMessagePublisher rabbitMessagePublisher

    def sendMessage(queue, message) {
        rabbitMessagePublisher.send {
            routingKey = queue
            body = [timestamp: new Date(), message: message]
        }
    }


    def listenToQueue(queue) {
        rabbitMessagePublisher.listen(queue) {
            message ->
            println message.body
        }
    }

}
