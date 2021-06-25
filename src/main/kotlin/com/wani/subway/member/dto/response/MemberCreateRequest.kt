package com.wani.subway.member.dto.response

import com.wani.subway.member.entity.Member

data class MemberCreateRequest(

    val email: String,

    val password: String,

    val age: Int
) {

    fun toMember(): Member =
        Member(
            id = null,
            email = email,
            password = password,
            age = age
        )
}
