package com.wani.subway.subway.member.acceptance

import com.wani.subway.AcceptanceTest
import com.wani.subway.subway.member.step.MemberSteps
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
        MemberSteps.회원_생성_요청()
        // 회원 생성됨

    }
}