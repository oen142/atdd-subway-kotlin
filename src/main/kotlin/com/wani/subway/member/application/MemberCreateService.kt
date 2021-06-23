package com.wani.subway.member.application

import com.wani.subway.member.dto.response.MemberCreateRequest
import com.wani.subway.member.dto.response.MemberCreateResponse

interface MemberCreateService {

    fun createMember(request: MemberCreateRequest) : MemberCreateResponse

}
