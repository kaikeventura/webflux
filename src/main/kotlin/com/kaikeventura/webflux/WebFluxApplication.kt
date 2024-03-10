package com.kaikeventura.webflux

import com.kaikeventura.webflux.document.TaxType
import com.kaikeventura.webflux.service.CompanyService
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.stereotype.Component

@SpringBootApplication
@EnableReactiveMongoRepositories
class WebFluxApplication

fun main(args: Array<String>) {
	runApplication<WebFluxApplication>(*args)
}

@Component
class Init(
	private val companyService: CompanyService
) {
	@PostConstruct
	fun run() {
		TaxType.entries.forEach {
			companyService.addTax(
				companyId = "65ed1417b552e602dab19241",
				taxType = it,
				percentage = 10.3
			)
		}
//		for (i in 1..1000) {
//			val company = companyService.createCompany("Coquinha geladinha")
//			println(company.block()?.id!!)
//			TaxType.entries.forEach {
//				companyService.addTax(
//					companyId = company.block()?.id!!,
//					taxType = it,
//					percentage = 10.3
//				)
//			}
//		}
	}
}
