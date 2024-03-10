package com.kaikeventura.webflux.controller

import com.kaikeventura.webflux.service.CompanyService
import com.kaikeventura.webflux.service.CompanyTaxes
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/company")
class CompanyController(
    private val companyService: CompanyService
) {

    @GetMapping("/{id}")
    fun getCompanyTaxes(@PathVariable id: String): Mono<CompanyTaxes> =
        companyService.getCompanyTaxes(id)
}
