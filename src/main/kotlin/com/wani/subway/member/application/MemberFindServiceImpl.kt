package com.wani.subway.member.application

import com.wani.subway.member.dto.response.MemberFindResponse
import com.wani.subway.member.exception.NoSuchMemberException
import com.wani.subway.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberFindServiceImpl(
    val memberRepository: MemberRepository
) : MemberFindService {

    override fun findMember(id: Long): MemberFindResponse {
        val member = memberRepository.findById(id)
            .orElseThrow {
                throw NoSuchMemberException("해당 하는 id : $id 의 소유주를 확인할 수 없습니다.")
            }

        return MemberFindResponse(
            id = member.id ?: 0L,
            email = member.email,
            age = member.age
        )
    }
}