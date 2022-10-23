package gy.roach.modulith.apis.country.web

import gy.roach.modulith.apis.country.model.Country
import gy.roach.modulith.apis.country.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/country")
class CountryController (
    @Autowired private val countryService: CountryService
){
    @GetMapping("/")
    fun getCity(): Country {
        return countryService.getCity()
    }

}