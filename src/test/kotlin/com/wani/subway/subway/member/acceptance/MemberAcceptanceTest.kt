package com.wani.subway.subway.member.acceptance

import com.wani.subway.AcceptanceTest
import com.wani.subway.subway.member.step.MemberSteps
import com.wani.subway.subway.member.step.MemberStepsAssert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("회원 인수 테스트")
class MemberAcceptanceTest : AcceptanceTest() {

    @BeforeEach
    override fun setUp() {
        super.setUp()
    }


    @Test
    fun `회원가입을 할수 있다`() {

        // 회원 생성 요청
        val response = MemberSteps.회원_생성_요청(MemberSteps.EMAIL, MemberSteps.PASSWORD, MemberSteps.AGE)
        // 회원 생성됨
        MemberStepsAssert.회원_생성됨(response)
    }
}