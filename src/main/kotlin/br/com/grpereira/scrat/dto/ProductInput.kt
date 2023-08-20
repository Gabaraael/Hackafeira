package br.com.grpereira.scrat.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ProductInput @JsonCreator constructor(
        @JsonProperty("ncm") val ncm: Int,
        @JsonProperty("id_loja") val storeId: Long,
        @JsonProperty("estoque_min") val minStock: Int,
        @JsonProperty("estoque_max") val maxStock: Int,
        @JsonProperty("data_vencimento") val expirationDate: String,
        @JsonProperty("estoque_atual") val currentStock: Int,
        @JsonProperty("faixa_venda") val salesRange: Int,
        @JsonProperty("estoque_media") val averageStock: Double,
        @JsonProperty("m_jan") val janQty: Int,
        @JsonProperty("m_fev") val febQty: Int,
        @JsonProperty("m_mar") val marQty: Int,
        @JsonProperty("m_abr") val aprQty: Int,
        @JsonProperty("m_mai") val mayQty: Int,
        @JsonProperty("m_jun") val junQty: Int,
        @JsonProperty("m_jul") val julQty: Int,
        @JsonProperty("m_ago") val augQty: Int,
        @JsonProperty("m_set") val sepQty: Int,
        @JsonProperty("m_out") val octQty: Int,
        @JsonProperty("m_nov") val novQty: Int,
        @JsonProperty("m_dez") val decQty: Int,
        @JsonProperty("sem_1") val week1Qty: Int,
        @JsonProperty("sem_2") val week2Qty: Int,
        @JsonProperty("sem_3") val week3Qty: Int,
        @JsonProperty("sem_4") val week4Qty: Int,
        @JsonProperty("vencimento_close") val expirationClose: Int
)