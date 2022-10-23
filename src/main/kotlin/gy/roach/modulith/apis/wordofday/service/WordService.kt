package gy.roach.modulith.apis.wordofday.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import gy.roach.modulith.apis.events.WordReceivedEvent
import gy.roach.modulith.apis.wordofday.model.Word
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.io.InputStreamReader


@Service
class WordService (@Autowired private val events: ApplicationEventPublisher,
    private val objectMapper: ObjectMapper){
    private val words = mutableListOf<Word>()
    private var num: IntRange
    init {
        val parser = CSVParserBuilder()
            .withSeparator(',')
            .build()
        val reader = CSVReaderBuilder(InputStreamReader(WordService::class.java.classLoader.getResourceAsStream("db/list.csv")))
            .withCSVParser(parser)
            .build()
        var lines: List<Array<String>> = ArrayList()
        lines = reader.readAll()
        reader.close()
        lines.forEach {
            words.add(Word(it.get(0), it.get(1), it.get(2)))
        }
        num = (0 until words.size)

    }

    fun getWord(): Word {
        val word = words[num.random()]
        events.publishEvent(WordReceivedEvent(objectMapper.writeValueAsString(word)))
        return word
    }
}