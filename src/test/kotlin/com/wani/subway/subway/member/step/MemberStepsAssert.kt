package com.wani.subway.subway.member.step

import com.wani.subway.member.dto.response.MemberFindResponse
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus

object MemberStepsAssert {

    fun `회원_생성됨`(response: ExtractableResponse<Response>) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
    }

    fun `회원_정보_조회됨`(response: ExtractableResponse<Response>, email: String, age: Int) {
        val memberFindResponse = response.`as`(MemberFindResponse::class.java)

        assertThat(memberFindResponse.id).isNotNull
        assertThat(memberFindResponse.email).isEqualTo(email)
        assertThat(memberFindResponse.age).isEqualTo(age)
    }
}