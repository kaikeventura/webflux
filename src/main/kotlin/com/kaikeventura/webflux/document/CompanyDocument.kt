package com.kaikeventura.webflux.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "company")
data class CompanyDocument(
    @Id
    val id: String? = null,
    val name: String,
    val taxes: Set<TaxDocument> = emptySet()
)

data class TaxDocument(
    val type: TaxType,
    val percentage: Double
)

enum class TaxType {
    IPI, IOF, PIS
}
