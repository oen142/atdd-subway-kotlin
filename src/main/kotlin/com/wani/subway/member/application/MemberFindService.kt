package com.wani.subway.member.application

import com.wani.subway.member.dto.response.MemberFindResponse

interface MemberFindService {

    fun findMember(id: Long): MemberFindResponse

}
