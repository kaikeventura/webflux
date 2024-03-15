package com.kaikeventura.webflux

import com.kaikeventura.webflux.controller.TaxDTO
import com.kaikeventura.webflux.document.TaxType
import com.kaikeventura.webflux.repository.CompanyRepository
import com.kaikeventura.webflux.service.CompanyService
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@SpringBootApplication
@EnableReactiveMongoRepositories
class WebFluxApplication

fun main(args: Array<String>) {
	runApplication<WebFluxApplication>(*args)
}

@Component
class Init(
	private val companyService: CompanyService,
	private val companyRepository: CompanyRepository
) {
	@PostConstruct
	fun run() {
//		println(companyRepository.findAll().count().block())
//		companyRepository.findAll().subscribe {
//			println("oi")
//			companyService.addTax(
//				companyId = it.id!!,
//				taxDTO = TaxDTO(TaxType.entries.random(), 3.0),
//			)
//		}
	}
}
