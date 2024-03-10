package com.kaikeventura.webflux.repository

import com.kaikeventura.webflux.document.CompanyDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : ReactiveMongoRepository<CompanyDocument, String>
