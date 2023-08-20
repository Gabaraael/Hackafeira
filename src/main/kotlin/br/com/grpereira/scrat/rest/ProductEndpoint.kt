package br.com.grpereira.scrat.rest

import br.com.grpereira.scrat.dto.page.ProductOutputPage
import br.com.grpereira.scrat.rest.service.ProductService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = ["*"])
class ProductEndpoint(
        private val productService: ProductService
) {
    @GetMapping("/store/{storeId}")
    fun getProduct(@PathVariable storeId: Long,
                   @RequestParam(defaultValue = "") query: String,
                   @RequestParam(defaultValue = "0") page: Int,
                   @RequestParam(defaultValue = "12") pageSize: Int): ResponseEntity<ProductOutputPage> {
        val pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "stockToSend"))

        var products = productService.findByStoreId(storeId)
        if (query.isNotEmpty())
            products = products.filter{i -> i.ncm!!.contains(query)}
        val pages = ProductOutputPage.createProductOutputPage(pageRequest, products, products.size.toLong())
        return ResponseEntity.ok(pages)
    }
}