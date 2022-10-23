package gy.roach.modulith.apis.country.service

import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import gy.roach.modulith.apis.country.model.Country
import org.springframework.stereotype.Service
import java.io.InputStreamReader

@Service
class CountryService {
    private val countries = mutableListOf<Country>()
    private var num: IntRange
    init {
        val parser = CSVParserBuilder()
            .withSeparator(',')
            .build()
        val reader = CSVReaderBuilder(InputStreamReader(CountryService::class.java.classLoader.getResourceAsStream("countrydb/countries.csv")))
            .withCSVParser(parser)
            .build()
        var lines: List<Array<String>> = ArrayList()
        lines = reader.readAll()
        reader.close()
        lines.forEach {
            countries.add(Country(it.get(0), it.get(1)))
        }
        num = (0 until countries.size)

    }

    fun getCity(): Country {
        return countries[num.random()]
    }
}