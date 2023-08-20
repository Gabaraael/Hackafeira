package br.com.grpereira.scrat.infra.feign

import br.com.grpereira.scrat.dto.ProductInput
import br.com.grpereira.scrat.dto.ProductResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class IAClient(private val mapper: ObjectMapper,
        private val restTemplate: RestTemplate) {
    companion object {
        val URL = "http://localhost:6000/estoque_zero"
    }

    fun sendToIA(productData: List<ProductInput>): List<ProductResponse> {
        val responseJson = restTemplate.postForObject(URL, productData, String::class.java)
        val responseJson2 = responseJson!!.replace("\\","").drop(1).dropLast(1)
        var response = mapper.readValue(responseJson2, Array<ProductResponse>::class.java)
        return response.toList()
    }
}
