package br.com.grpereira.scrat.rest.service

import br.com.grpereira.scrat.dto.ProductResponse
import br.com.grpereira.scrat.infra.feign.IAClient
import br.com.grpereira.scrat.utils.MockUtil
import org.springframework.stereotype.Service

@Service
class ProductService(private val iaClient: IAClient) {

    fun findByStoreId (storeId: Long): List<ProductResponse> {
        // Simula o banco de dados
        val productData = MockUtil.createMockData()
        return iaClient.sendToIA(productData.toList()).filter { it.storeId == storeId }
    }
}