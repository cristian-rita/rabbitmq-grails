package rabbitmq.grails

class MessageController {

    def messageService

    def index() {

    }

    def save() {
        messageService.sendMessage("myqueue", params.message)
        redirect(action: 'index')
    }
}
