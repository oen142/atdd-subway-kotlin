package com.wani.subway.subway.member.step

import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus

object MemberStepsAssert {

    fun `회원_생성됨`(response: ExtractableResponse<Response>) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
    }
}