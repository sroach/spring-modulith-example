package gy.roach.modulith.apis.myobservability.service

import gy.roach.modulith.apis.events.WordReceivedEvent
import gy.roach.modulith.apis.wordofday.model.Word
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
open class WordViewer(@Autowired private val events: ApplicationEventPublisher) {


    @Async
    @EventListener
    open fun wordReceived(wordReceivedEvent: WordReceivedEvent) {
        println(wordReceivedEvent.event)
    }
}