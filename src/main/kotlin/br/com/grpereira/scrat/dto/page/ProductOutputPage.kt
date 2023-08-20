package br.com.grpereira.scrat.dto.page

import br.com.grpereira.scrat.dto.ProductResponse
import org.springframework.data.domain.PageRequest

data class ProductOutputPage(val content: List<ProductResponse>,
                             val pageNumber: Int,
                             val pageSize: Int,
                             val totalElements: Long,
                             val totalPage: Long) {
    companion object {
        fun createProductOutputPage(pageRequest: PageRequest,
                                    products: List<ProductResponse>,
                                    totalElements: Long): ProductOutputPage {

            val pageSize = pageRequest.pageSize
            val pageNumber = pageRequest.pageNumber
            val totalPage = totalElements/pageSize

            return ProductOutputPage(
                    content = products.subList(pageSize*pageNumber, Math.min(pageSize*(pageNumber+1), totalElements.toInt())),
                    pageNumber = pageRequest.pageNumber,
                    pageSize = pageRequest.pageSize,
                    totalElements = totalElements,
                    totalPage = totalPage)
        }
    }
}


