package br.com.grpereira.scrat.utils

import br.com.grpereira.scrat.dto.ProductInput
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.io.ClassPathResource

class MockUtil {

    companion object {
        fun createMockData(): Array<ProductInput> {
            val jsonFilePath = "mock/df_base.json"
            val resource = ClassPathResource(jsonFilePath)
            val json = resource.inputStream.reader().readText()
            val objectMapper = ObjectMapper()
            return objectMapper.readValue(json, Array<ProductInput>::class.java)
        }
    }
}