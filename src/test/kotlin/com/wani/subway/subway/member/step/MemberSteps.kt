package com.wani.subway.subway.member.step

import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.springframework.http.MediaType

object MemberSteps {

    const val EMAIL: String = "email@naver.com"
    const val PASSWORD: String = "password"
    const val AGE: Int = 30

    fun `회원_생성_요청`(email: String, password: String, age: Int): ExtractableResponse<Response> {

        val params: MutableMap<String, String> = HashMap()
        params["email"] = email
        params["password"] = password
        params["age"] = age.toString()

        return RestAssured
            .given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(params)
            .`when`().post("/members")
            .then().log().all().extract()
    }
}
