package com.wani.subway

import com.wani.subway.subway.util.DatabaseCleanup
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import java.lang.RuntimeException

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcceptanceTest {

    @LocalServerPort
    var port: Int = 0

    @Autowired
    var databaseCleanup: DatabaseCleanup? = null

    @BeforeEach
    fun setUp() {
        RestAssured.port = port
        databaseCleanup?.execute() ?: throw RuntimeException("인입이 안되었습니다")
    }
}