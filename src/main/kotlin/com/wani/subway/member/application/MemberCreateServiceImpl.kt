package com.wani.subway.member.application

import com.wani.subway.member.dto.response.MemberCreateRequest
import com.wani.subway.member.dto.response.MemberCreateResponse
import com.wani.subway.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberCreateServiceImpl(
    val memberRepository: MemberRepository
) : MemberCreateService {

    @Transactional
    override fun createMember(request: MemberCreateRequest): MemberCreateResponse {
        val member = request.toMember()

        println("멤버 세이브 전 :  ${member.id}")
        memberRepository.save(member)
        println("멤버 세이브 후 :  ${member.id}")
        return MemberCreateResponse(
            id = member.id ?: 0L,
            email = member.email,
            age = member.age
        )
    }
}