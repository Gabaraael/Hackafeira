package br.com.grpereira.scrat.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

data class ProductResponse @JsonCreator constructor (
        @JsonProperty("ncm") val ncm: String?,
        @JsonProperty("id_loja") val storeId: Long?,
        @JsonProperty("qtd_produto") val stockToSend: Long?,
        @JsonProperty("estoque_pos_acumulado") val cumulativeStock: Long,
        @JsonProperty("data_vencimento") val expirationDate: Timestamp?,
        @JsonProperty("data_escoamento") val exitDate: Timestamp?
)