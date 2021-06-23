package com.wani.subway.member.application

import com.wani.subway.member.dto.response.MemberCreateRequest
import com.wani.subway.member.dto.response.MemberCreateResponse
import com.wani.subway.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberCreateServiceImpl(
    val memberRepository: MemberRepository
) : MemberCreateService {

    override fun createMember(request: MemberCreateRequest): MemberCreateResponse {
        val member = request.toMember()

        memberRepository.save(member)

        return MemberCreateResponse(
            id = member.id ?: 0L,
            email = member.email,
            age = member.age
        )
    }
}