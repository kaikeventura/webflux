package com.kaikeventura.webflux.service

import com.kaikeventura.webflux.controller.TaxDTO
import com.kaikeventura.webflux.document.CompanyDocument
import com.kaikeventura.webflux.document.TaxDocument
import com.kaikeventura.webflux.document.TaxType
import com.kaikeventura.webflux.repository.CompanyRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CompanyService(
    private val companyRepository: CompanyRepository
) {
    fun createCompany(companyName: String): Mono<CompanyDocument> =
        companyRepository.save(
            CompanyDocument(
                name = companyName
            )
        )

    fun addTax(
        companyId: String,
        taxDTO: TaxDTO
    ): Mono<CompanyDocument> =
        companyRepository.findById(companyId)
            .switchIfEmpty(Mono.error(RuntimeException("Company $companyId not found")))
            .flatMap {
                companyRepository.save(
                    it.copy(
                        taxes = it.taxes.plus(
                            TaxDocument(
                                type = taxDTO.taxType,
                                percentage = taxDTO.percentage
                            )
                        )
                    )
                )
            }

    fun getCompanyTaxes(companyId: String): Mono<CompanyTaxes> {
        return companyRepository.findById(companyId)
                .switchIfEmpty(Mono.error(RuntimeException("Company $companyId not found")))
                .flatMap { companyDocument ->
                    Mono.just(
                        CompanyTaxes(
                            id = companyDocument.id!!,
                            taxes = companyDocument.taxes.map {
                                Tax(
                                    type = it.type,
                                    percentage = it.percentage
                                )
                            }
                        )
                    )
        }

    }
}

data class CompanyTaxes(
    val id: String,
    val taxes: List<Tax>
)

data class Tax(
    val type: TaxType,
    val percentage: Double
)
