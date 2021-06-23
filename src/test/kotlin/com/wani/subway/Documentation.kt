package com.wani.subway

import com.wani.subway.subway.util.DatabaseCleanup
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(RestDocumentationExtension::class)
class Documentation(

    @LocalServerPort
    val port: Int,

    @Autowired
    val databaseCleanup: DatabaseCleanup,

    protected var spec: RequestSpecification
) {

    @BeforeEach
    fun setUp(restDocumentation: RestDocumentationContextProvider) {
        RestAssured.port = port
        databaseCleanup.execute()

        this.spec = RequestSpecBuilder()
            .addFilter(documentationConfiguration(restDocumentation))
            .build()
    }

}