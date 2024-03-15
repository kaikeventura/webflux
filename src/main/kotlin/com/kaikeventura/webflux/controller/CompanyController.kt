package com.kaikeventura.webflux.controller

import com.kaikeventura.webflux.document.CompanyDocument
import com.kaikeventura.webflux.document.TaxType
import com.kaikeventura.webflux.service.CompanyService
import com.kaikeventura.webflux.service.CompanyTaxes
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/company")
class CompanyController(
    private val companyService: CompanyService
) {

    @PostMapping
    fun saveCompany(@RequestBody companyDTO: CompanyDTO): Mono<CompanyDocument> =
        companyService.createCompany(
            companyName = companyDTO.companyName
        )

    @PutMapping("/{id}/tax")
    fun addTax(
        @PathVariable id: String,
        @RequestBody taxDTO: TaxDTO
    ): Mono<CompanyDocument> =
        companyService.addTax(
            companyId = id,
            taxDTO = taxDTO
        )

    @GetMapping("/{id}")
    fun getCompanyTaxes(@PathVariable id: String): Mono<CompanyTaxes> =
        companyService.getCompanyTaxes(id)
}

data class CompanyDTO(
    val companyName: String
)

data class TaxDTO(
    val taxType: TaxType,
    val percentage: Double
)
