package gy.roach.modulith.apis.wordofday.web

import gy.roach.modulith.apis.wordofday.service.WordService
import gy.roach.modulith.apis.wordofday.model.Word
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/word")
class WordOfDayController (
    @Autowired private val wordService: WordService
){
    @GetMapping("/")
    fun getWord(): Word {
        return wordService.getWord()
    }

}